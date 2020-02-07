package com.sh.xml.lookup.service;

import com.sh.xml.udf.UDF;
import com.sh.xml.udf.UDFMapping;

/**
 * The Interface EDWToBDWLookupService.
 */
public interface LookupService {

	UDF lookupUDF(String edwName, String ufdName) throws Exception;

	UDFMapping getAllEDWUDFMappedToHive(String edwName) throws Exception;
}
