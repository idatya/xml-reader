package com.sh.xml.lookup.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.springframework.stereotype.Service;

import com.sh.xml.bean.BeanUtil;
import com.sh.xml.common.config.service.CommonsConfigurationService;
import com.sh.xml.constant.LookupConstants;
import com.sh.xml.udf.UDF;
import com.sh.xml.udf.UDFMapping;

/**
 * The Class EDWToBDWLookupServiceImpl.
 */
@Service
public class LookupServiceImpl implements LookupService {

	/** The Constant UNABLE_TO_READ_UDF_MAPPING_FORM_THE_XML_FILE. */
	private static final String UNABLE_TO_READ_UDF_MAPPING_FORM_THE_XML_FILE = "Unable to read UDFMapping form the XML file";

	/** The Constant FILTER_FIELD_NAME. */
	private static final String FILTER_FIELD_NAME = "edwName";

	public UDF lookupUDF(String edwName, String ufdName) throws Exception {
		UDF udf = null;

		try {
			UDFMapping udfs = getUdfs(LookupConstants.ETLOFFLOAD_HIVEUDF_XML_ROOT,
					LookupConstants.ETLOFFLOAD_HIVEUDF_XML_CONFIGURATIONNAME, FILTER_FIELD_NAME, edwName);
			for (UDF udfMapped : udfs.getUdfsList()) {
				if (udfMapped.getUdfName().equalsIgnoreCase(ufdName)) {
					udf = udfMapped;
					break;
				}

			}

		} catch (Exception exception) {
			System.err.println(UNABLE_TO_READ_UDF_MAPPING_FORM_THE_XML_FILE
					+ LookupConstants.ETLOFFLOAD_HIVEUDF_XML_CONFIGURATIONNAME);
			throw new Exception(UNABLE_TO_READ_UDF_MAPPING_FORM_THE_XML_FILE
					+ LookupConstants.ETLOFFLOAD_HIVEUDF_XML_CONFIGURATIONNAME, exception);
		}

		System.out.println("EDW " + edwName + " Successfull lookupUDF for the UDF:" + ufdName);
		return udf;
	}

	public UDFMapping getAllEDWUDFMappedToHive(String edwName) throws Exception {
		UDFMapping udfs = null;
		try {
			udfs = getUdfs(LookupConstants.ETLOFFLOAD_HIVEUDF_XML_ROOT,
					LookupConstants.ETLOFFLOAD_HIVEUDF_XML_CONFIGURATIONNAME, FILTER_FIELD_NAME, edwName);

		} catch (Exception exception) {
			System.err.print(UNABLE_TO_READ_UDF_MAPPING_FORM_THE_XML_FILE
					+ LookupConstants.ETLOFFLOAD_HIVEUDF_XML_CONFIGURATIONNAME);
			throw new Exception(UNABLE_TO_READ_UDF_MAPPING_FORM_THE_XML_FILE
					+ LookupConstants.ETLOFFLOAD_HIVEUDF_XML_CONFIGURATIONNAME, exception);
		}

		System.out.println("Successfully Exit lookupUDF with edwType:" + edwName);
		return udfs;
	}

	private UDFMapping getUdfs(String root, String configurationName, String filterFieldName,
			String filterFieldValue) throws Exception {
		UDFMapping udfMapping = new UDFMapping();
		udfMapping.setEdwName(filterFieldValue);

		List<UDF> udfsList = new ArrayList<UDF>();

		CommonsConfigurationService commonsConfigurationService = BeanUtil.getCommonsConfigurationService();
		XMLConfiguration xmlConfiguration = (XMLConfiguration) commonsConfigurationService
				.getConfiguration(configurationName);

		List<HierarchicalConfiguration> edws = xmlConfiguration.configurationsAt(root);

		// populate specific udf
		populateUdfDetails(filterFieldName, filterFieldValue, udfsList, edws);
		populateUdfDetails(filterFieldName, LookupConstants.ETLOFFLOAD_COMMON_EDW_UDF, udfsList, edws);

		System.out.println("Total UDFs Size:" + udfsList.size());
		udfMapping.setUdfsList(udfsList);

		return udfMapping;
	}

	private void populateUdfDetails(String filterFieldName, String filterFieldValue, List<UDF> udfsList,
			List<HierarchicalConfiguration> edws) {
		for (HierarchicalConfiguration edw : edws) {

			String value = edw.getString(filterFieldName);
			if (value != null && value.equalsIgnoreCase(filterFieldValue)) {
				List<Object> udfNames = edw.getList("udfs.udf.name");
				List<Object> udfPackages = edw.getList("udfs.udf.package-name");
				List<Object> mappedNames = edw.getList("udfs.udf.mappedBy");
				List<Object> mappedByInJavaNames = edw.getList("udfs.udf.mappedByInJava");
				int counter = 0;
				for (Object udfName : udfNames) {
					if (!checkDuplicateUDFMaping((String) udfName, udfsList)) {
						UDF udf = new UDF();
						udf.setUdfName((String) udfName);
						udf.setUdfClass((String) udfPackages.get(counter));
						udf.setMappedBy((String) mappedNames.get(counter));
						udf.setMappedByInJava((String) mappedByInJavaNames.get(counter));
						udfsList.add(udf);
					}
					counter++;
				}
				break;
			}
		}
	}

	private boolean checkDuplicateUDFMaping(String udfName, List<UDF> udfsList) {
		boolean isDuplicate = false;
		if (udfsList != null && !udfsList.isEmpty()) {
			for (UDF mapping : udfsList) {
				if (mapping.getUdfName().equalsIgnoreCase(udfName)) {
					isDuplicate = true;
					break;
				}
			}
		}

		return isDuplicate;

	}
}
