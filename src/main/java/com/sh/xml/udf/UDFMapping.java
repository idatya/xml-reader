package com.sh.xml.udf;

import java.util.List;

/**
 * The Class EDWToHiveUDFMapping.
 */
public class UDFMapping {
  
  /** The edw name. */
  private String edwName;
  
  /** The udfs list. */
  private List<UDF> udfsList;
  
  /**
   * Gets the edw name.
   *
   * @return the edw name
   */
  public String getEdwName() {
    return edwName;
  }
  
  /**
   * Sets the edw name.
   *
   * @param edwName
   *          the new edw name
   */
  public void setEdwName(String edwName) {
    this.edwName = edwName;
  }
  
  /**
   * Gets the udfs list.
   *
   * @return the udfs list
   */
  public List<UDF> getUdfsList() {
    return udfsList;
  }
  
  /**
   * Sets the udfs list.
   *
   * @param udfsList
   *          the new udfs list
   */
  public void setUdfsList(List<UDF> udfsList) {
    this.udfsList = udfsList;
  }
  
}
