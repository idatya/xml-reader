package com.sh.xml.common.config;

import java.io.File;

import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.DefaultConfigurationBuilder;
import org.apache.commons.configuration.EnvironmentConfiguration;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonsConfiguration {
  
  /** The Constant LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(CommonsConfiguration.class);
  
  public static final String COMMONS_CONFIG_FILE_PATH =
      File.separator + "core" + File.separator + "common-configuration.xml";

  
  /** The configuration. */
  private static CombinedConfiguration configuration;
  
  public static String HOME = null;
  
  public static String CONF = null;
  
  public static String JAVA_HOME = null;
  
  public static String LOG = null;
  
  public static String THIRD_PARTY_JARS = null;
  
  public static String SFTP_USER_STR = null;
  
  public static String SFTP_PASSWORD_STR = null;
  
  /**
   * Gets the combined configuration.
   *
   * @return the combined configuration
 * @throws s 
   */
  public static CombinedConfiguration getCombinedConfiguration() throws Exception {
    
    synchronized (CommonsConfiguration.class) {
      if (null == configuration) {
        try {
          
          loadDeploymentEnvVaribles();
          DefaultConfigurationBuilder builder =
              new DefaultConfigurationBuilder(new File(CONF + COMMONS_CONFIG_FILE_PATH));
          configuration = builder.getConfiguration(true);
          LOGGER.info("Commons Configuration file Loaded successfully");
        } catch (Exception e) {
          
          LOGGER.error("Configuration file cannot loaded from the path:" + CONF + COMMONS_CONFIG_FILE_PATH, e);
          throw new Exception(
              "Configuration file cannot loaded from the path:" + CONF + COMMONS_CONFIG_FILE_PATH);
        }
      }
    }
    
    if (null != configuration) {
      return configuration;
    }
    else {
      throw new Exception(
          "Configuration file cannot loaded from the path:" + CONF + COMMONS_CONFIG_FILE_PATH);
    }
  }
  
  /**
   * Load deployment env varibles.
   *
   * @throws EtlOffloadException
   *           the etl offload exception
   */
  private static void loadDeploymentEnvVaribles() throws Exception {
    
    try {
      
      Configuration envConfig = new EnvironmentConfiguration();
      HOME = "/home/impadmin/idw/idw_wmg/";
      CONF = "/home/impadmin/idw/idw_wmg/conf/";
      LOG = "/home/impadmin/idw/idw_wmg/logs";
      THIRD_PARTY_JARS = "/home/impadmin/idw/idw_wmg/logs/third_party_jars/";
      JAVA_HOME = "/home/impadmin/idw/java/jdk1.8.0_141/";
      if (StringUtils.isEmpty(HOME) || StringUtils.isEmpty(JAVA_HOME)) {
        LOGGER.error(
            "Not able to load IDW_WMG_HOME & JAVA_HOME envirment variables for the deployment System Environment. "
                + HOME + " &" + JAVA_HOME + "&" + CONF
                + " \n Example Configure like this  IDW_WMG_HOME=/var/lib/idw_wmg/:");
        throw new Exception(
            "Not able to load IDW_WMG_HOME & JAVA_HOME envirment variables for the deployment System Environment. "
                + HOME + " &" + JAVA_HOME + "&" + CONF
                + " \n Example Configure like this  IDW_WMG_HOME=/var/lib/idw_wmg/:");
      }
    } catch (Exception e) {
      LOGGER.error("Not able to load IDW_WMG_HOME & JAVA_HOME envirment variables for the deployment System Environment"
          + HOME + " &" + JAVA_HOME + "&" + CONF
          + " \n Example Configure like this  IDW_WMG_HOME=/var/lib/idw_wmg/:", e);
      throw new Exception(
          "Not able to load IDW_WMG_HOME & JAVA_HOME envirment variables for the deployment System Environment. "
              + HOME + " &" + JAVA_HOME + "&" + CONF
              + " \n Example Configure like this  IDW_WMG_HOME=/var/lib/idw_wmg/:");
      
    }
    
  }
}
