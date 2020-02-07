package com.sh.xml.constant;

public interface LookupConstants {
	/** The etloffload hiveudf xml root. */
	String ETLOFFLOAD_HIVEUDF_XML_ROOT = "edws.edw.";

	/** The etloffload datatypes xml root. */
	String ETLOFFLOAD_DATATYPES_XML_ROOT = "edws.edw.";

	/** The etloffload hiveudf xml configurationname. */
	String ETLOFFLOAD_HIVEUDF_XML_CONFIGURATIONNAME = "edwToHiveUDFMappingConf";

	/** The etloffload hive datatypes xml configurationname. */
	String ETLOFFLOAD_HIVE_DATATYPES_XML_CONFIGURATIONNAME = "edwToHiveDataTypeMappingConf";

	/** The etloffload phoenix hbase datatypes xml configurationname. */
	String ETLOFFLOAD_PHOENIX_HBASE_DATATYPES_XML_CONFIGURATIONNAME = "edwToPhoenixHbaseDataTypeMappingConf";

	/** The etloffload bdw to edw datatypes xml configurationname. */
	String ETLOFFLOAD_BDW_TO_EDW_DATATYPES_XML_CONFIGURATIONNAME = "hiveToEdwDataTypeMappingConf";

	/** The etloffload java datatypes xml configurationname. */
	String ETLOFFLOAD_JAVA_DATATYPES_XML_CONFIGURATIONNAME = "edwToJavaDataTypeMappingConf";

	/** The etloffload common edw udf. */
	String ETLOFFLOAD_COMMON_EDW_UDF = "commonedw";

	/** The sqloffload plsql exception configurationname. */
	String SQLOFFLOAD_PLSQL_EXCEPTION_CONFIGURATIONNAME = "edwPLSQLExceptionMappingConf";

	/** The generic plsql exception. */
	String GENERIC_PLSQL_EXCEPTION = "GENERIC_EXCEPTION";
}
