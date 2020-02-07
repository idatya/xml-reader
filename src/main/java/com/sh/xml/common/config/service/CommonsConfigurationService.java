package com.sh.xml.common.config.service;

import java.util.Map;

import org.apache.commons.configuration.Configuration;


public interface CommonsConfigurationService {
  
  /**
   * Gets the string.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @param propertyKey
   *          the property key
   * @return the string
 * @throws Exception 
   */
  String getString(String propertiesConfigName, String propertyKey) throws Exception;
  
  /**
   * Gets the short.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @param propertyKey
   *          the property key
   * @return the short
 * @throws Exception 
   */
  Short getShort(String propertiesConfigName, String propertyKey) throws Exception;
  
  /**
   * Gets the byte.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @param propertyKey
   *          the property key
   * @return the byte
 * @throws Exception 
   */
  Byte getByte(String propertiesConfigName, String propertyKey) throws Exception;
  
  /**
   * Gets the float.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @param propertyKey
   *          the property key
   * @return the float
 * @throws Exception 
   */
  Float getFloat(String propertiesConfigName, String propertyKey) throws Exception;
  
  /**
   * Gets the long.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @param propertyKey
   *          the property key
   * @return the long
 * @throws Exception 
   */
  Long getLong(String propertiesConfigName, String propertyKey) throws Exception;
  
  /**
   * Gets the double.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @param propertyKey
   *          the property key
   * @return the double
 * @throws Exception 
   */
  Double getDouble(String propertiesConfigName, String propertyKey) throws Exception;
  
  /**
   * Gets the integer.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @param propertyKey
   *          the property key
   * @return the integer
 * @throws Exception 
   */
  Integer getInteger(String propertiesConfigName, String propertyKey) throws Exception;
  
  /**
   * Gets the boolean.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @param propertyKey
   *          the property key
   * @return the boolean
 * @throws Exception 
   */
  Boolean getBoolean(String propertiesConfigName, String propertyKey) throws Exception;
  
  /**
   * Gets the configuration.
   *
   * @param ConfigName
   *          the config name
   * @return the configuration
 * @throws Exception 
   */
  Configuration getConfiguration(String ConfigName) throws Exception;
  
  /**
   * Gets the properties.
   *
   * @param propertiesConfigName
   *          the properties config name
   * @return the properties
   */
  Map<String, String> getProperties(String propertiesConfigName);
  
}
