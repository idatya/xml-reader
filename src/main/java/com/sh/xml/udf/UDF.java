package com.sh.xml.udf;

/**
 * The Class UDF.
 */
public class UDF {
  
  /** The udf name. */
  private String udfName;
  
  /** The mapped by. */
  private String mappedBy;
  
  /** The mapped by in java. */
  private String mappedByInJava;
  
  /** The udf class. */
  private String udfClass;
  
  /**
   * Gets the udf name.
   *
   * @return the udf name
   */
  public String getUdfName() {
    return udfName;
  }
  
  /**
   * Sets the udf name.
   *
   * @param udfName
   *          the new udf name
   */
  public void setUdfName(String udfName) {
    this.udfName = udfName;
  }
  
  /**
   * Gets the udf class.
   *
   * @return the udf class
   */
  public String getUdfClass() {
    return udfClass;
  }
  
  /**
   * Sets the udf class.
   *
   * @param udfClass
   *          the new udf class
   */
  public void setUdfClass(String udfClass) {
    this.udfClass = udfClass;
  }
  
  /**
   * Gets the mapped by.
   *
   * @return the mapped by
   */
  public String getMappedBy() {
    return mappedBy;
  }
  
  /**
   * Sets the mapped by.
   *
   * @param mappedBy
   *          the new mapped by
   */
  public void setMappedBy(String mappedBy) {
    this.mappedBy = mappedBy;
  }
  
  /**
   * Gets the mapped by in java.
   *
   * @return the mapped by in java
   */
  public String getMappedByInJava() {
    return mappedByInJava;
  }
  
  /**
   * Sets the mapped by in java.
   *
   * @param mappedByInJava
   *          the new mapped by in java
   */
  public void setMappedByInJava(String mappedByInJava) {
    this.mappedByInJava = mappedByInJava;
  }
  
  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return " UDF {udfName=" + udfName + ",udfClass=" + udfClass + "}";
  }
}
