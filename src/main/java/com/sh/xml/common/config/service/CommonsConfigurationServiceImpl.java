package com.sh.xml.common.config.service;

import java.text.MessageFormat;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sh.xml.common.config.CommonsConfiguration;
import com.sh.xml.constant.Constants;


/**
 * The Class CommonsConfigurationServiceImpl.
 *
 */
public class CommonsConfigurationServiceImpl implements CommonsConfigurationService {
  
  /** The Constant LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(CommonsConfigurationServiceImpl.class);
  
  /** The configuration service. */
  private static CommonsConfigurationService configurationService = null;
  
  /** The Constant scriptVariableHeadSymbol. */
  private static final String scriptVariableHeadSymbol = "\\$\\{";
  
  /** The Constant scriptVariableTailSymbol. */
  private static final String scriptVariableTailSymbol = "\\}";
  
  /**
   * Gets the single instance of CommonsConfigurationServiceImpl.
   * 
   * @return single instance of CommonsConfigurationServiceImpl
   */
  public static CommonsConfigurationService getInstance() {
    if (configurationService == null) {
      synchronized (CommonsConfigurationServiceImpl.class) {
        if (configurationService == null)
          configurationService = new CommonsConfigurationServiceImpl();
      }
    }
    return configurationService;
  }
  
  /**
   * Instantiates a new commons configuration service impl.
   */
  private CommonsConfigurationServiceImpl() {
    
  }
  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getProperties(java.lang.String)
   */
  public Map<String, String> getProperties(String propertiesConfigName) {
    return null;
  }
  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getString(java.lang.String,
   * java.lang.String)
   */
  public String getString(String propertiesConfigName, String propertyKey) throws Exception {
    handlePropertyException(propertiesConfigName, propertyKey);
    
    String propertyStrValue = null;
    try {
      propertyStrValue =
          CommonsConfiguration.getCombinedConfiguration().getString(propertyKey);
      
      if (propertyStrValue.contains(Constants.HOME)) {
        propertyStrValue =
            propertyStrValue.replaceAll(scriptVariableHeadSymbol + Constants.HOME + scriptVariableTailSymbol,
                CommonsConfiguration.HOME);
      }
      
      if (propertyStrValue.contains(Constants.CONF)) {
        propertyStrValue =
            propertyStrValue.replaceAll(scriptVariableHeadSymbol + Constants.CONF + scriptVariableTailSymbol,
                CommonsConfiguration.CONF);
      }
      
      if (propertyStrValue.contains(Constants.LOG)) {
        propertyStrValue =
            propertyStrValue.replaceAll(scriptVariableHeadSymbol + Constants.LOG + scriptVariableTailSymbol,
                CommonsConfiguration.LOG);
      }
      
      if (propertyStrValue.contains(Constants.THIRD_PARTY_JARS)) {
        propertyStrValue = propertyStrValue.replaceAll(
            scriptVariableHeadSymbol + Constants.THIRD_PARTY_JARS + scriptVariableTailSymbol,
            CommonsConfiguration.THIRD_PARTY_JARS);
      }
      
      if (propertyStrValue.contains(Constants.SFTP_USER_STR)) {
        if (StringUtils.isNotEmpty(CommonsConfiguration.SFTP_USER_STR)) {
          propertyStrValue = propertyStrValue.replaceAll(
              scriptVariableHeadSymbol + Constants.SFTP_USER_STR + scriptVariableTailSymbol,
              CommonsConfiguration.SFTP_USER_STR);
        }
      }
      
      if (propertyStrValue.contains(Constants.SFTP_PASSWORD_STR)) {
        if (StringUtils.isNotEmpty(CommonsConfiguration.SFTP_PASSWORD_STR)) {
          propertyStrValue = propertyStrValue.replaceAll(
              scriptVariableHeadSymbol + Constants.SFTP_PASSWORD_STR + scriptVariableTailSymbol,
              CommonsConfiguration.SFTP_PASSWORD_STR);
        }
      }
      
    } catch (Exception e) {
      LOGGER.error("ERROR in handling ENV variables in propertiesConfigName = " + propertiesConfigName
          + " , propertyKey =  " + propertyKey + " , propertyStrValue = " + propertyStrValue, e);
    }
    return propertyStrValue;
  }
  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getShort(java.lang.String,
   * java.lang.String)
   */
  public Short getShort(String propertiesConfigName, String propertyKey) throws Exception {
    handlePropertyException(propertiesConfigName, propertyKey);
    return CommonsConfiguration.getCombinedConfiguration().getShort(propertyKey);
  }
  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getByte(java.lang.String,
   * java.lang.String)
   */
  public Byte getByte(String propertiesConfigName, String propertyKey) throws Exception {
    handlePropertyException(propertiesConfigName, propertyKey);
    return CommonsConfiguration.getCombinedConfiguration().getByte(propertyKey);
  }
  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getFloat(java.lang.String,
   * java.lang.String)
   */
  public Float getFloat(String propertiesConfigName, String propertyKey) throws Exception {
    handlePropertyException(propertiesConfigName, propertyKey);
    return CommonsConfiguration.getCombinedConfiguration().getFloat(propertyKey);
  }
  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getLong(java.lang.String,
   * java.lang.String)
   */
  public Long getLong(String propertiesConfigName, String propertyKey) throws Exception {
    handlePropertyException(propertiesConfigName, propertyKey);
    return CommonsConfiguration.getCombinedConfiguration().getLong(propertyKey);
  }
  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getDouble(java.lang.String,
   * java.lang.String)
   */
  public Double getDouble(String propertiesConfigName, String propertyKey) throws Exception {
    handlePropertyException(propertiesConfigName, propertyKey);
    return CommonsConfiguration.getCombinedConfiguration()
        .getDouble(propertyKey);
  }
  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getInteger(java.lang.String,
   * java.lang.String)
   */
  public Integer getInteger(String propertiesConfigName, String propertyKey) throws Exception {
    handlePropertyException(propertiesConfigName, propertyKey);
    return CommonsConfiguration.getCombinedConfiguration().getInt(propertyKey);
  }
  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getBoolean(java.lang.String,
   * java.lang.String)
   */
  public Boolean getBoolean(String propertiesConfigName, String propertyKey) throws Exception {
    handlePropertyException(propertiesConfigName, propertyKey);
    return CommonsConfiguration.getCombinedConfiguration()
        .getBoolean(propertyKey);
  }
  
  /**
   * Handle property exception.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @param propertyKey
   *          the property key
 * @throws Exception 
   */
  private void handlePropertyException(String propertiesConfigName, String propertyKey) throws Exception {
    String propertyNotFound = null;
    String formattedMessage = null;
    

    if (propertyKey != null) {
      if (CommonsConfiguration.getCombinedConfiguration().getString(propertyKey) == null) {
        propertyNotFound = "property_not_found";
        formattedMessage = MessageFormat.format(propertyNotFound, new Object[] { propertyKey, propertiesConfigName });
          LOGGER.error(formattedMessage);
          throw new Exception(formattedMessage);
      }
    }
    
  }  
  /*
   * (non-Javadoc)
   * @see com.impetus.idw.wmg.core.configuration.CommonsConfigurationService# getConfiguration(java.lang.String)
   */
  public Configuration getConfiguration(String ConfigName) throws Exception {
    handlePropertyException(ConfigName, null);
    return CommonsConfiguration.getCombinedConfiguration().getConfiguration(ConfigName);
  }
  
}
