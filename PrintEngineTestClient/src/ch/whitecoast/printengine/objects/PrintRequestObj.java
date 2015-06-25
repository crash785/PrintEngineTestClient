/**
 * PrintRequestObj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ch.whitecoast.printengine.objects;

public class PrintRequestObj  implements java.io.Serializable {
    private byte[] fileData;

    private java.lang.String fileType;

    private java.lang.String responseType;

    private ch.whitecoast.printengine.objects.ValueMap[] valueMaps;

    public PrintRequestObj() {
    }

    public PrintRequestObj(
           byte[] fileData,
           java.lang.String fileType,
           java.lang.String responseType,
           ch.whitecoast.printengine.objects.ValueMap[] valueMaps) {
           this.fileData = fileData;
           this.fileType = fileType;
           this.responseType = responseType;
           this.valueMaps = valueMaps;
    }


    /**
     * Gets the fileData value for this PrintRequestObj.
     * 
     * @return fileData
     */
    public byte[] getFileData() {
        return fileData;
    }


    /**
     * Sets the fileData value for this PrintRequestObj.
     * 
     * @param fileData
     */
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }


    /**
     * Gets the fileType value for this PrintRequestObj.
     * 
     * @return fileType
     */
    public java.lang.String getFileType() {
        return fileType;
    }


    /**
     * Sets the fileType value for this PrintRequestObj.
     * 
     * @param fileType
     */
    public void setFileType(java.lang.String fileType) {
        this.fileType = fileType;
    }


    /**
     * Gets the responseType value for this PrintRequestObj.
     * 
     * @return responseType
     */
    public java.lang.String getResponseType() {
        return responseType;
    }


    /**
     * Sets the responseType value for this PrintRequestObj.
     * 
     * @param responseType
     */
    public void setResponseType(java.lang.String responseType) {
        this.responseType = responseType;
    }


    /**
     * Gets the valueMaps value for this PrintRequestObj.
     * 
     * @return valueMaps
     */
    public ch.whitecoast.printengine.objects.ValueMap[] getValueMaps() {
        return valueMaps;
    }


    /**
     * Sets the valueMaps value for this PrintRequestObj.
     * 
     * @param valueMaps
     */
    public void setValueMaps(ch.whitecoast.printengine.objects.ValueMap[] valueMaps) {
        this.valueMaps = valueMaps;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrintRequestObj)) return false;
        PrintRequestObj other = (PrintRequestObj) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fileData==null && other.getFileData()==null) || 
             (this.fileData!=null &&
              java.util.Arrays.equals(this.fileData, other.getFileData()))) &&
            ((this.fileType==null && other.getFileType()==null) || 
             (this.fileType!=null &&
              this.fileType.equals(other.getFileType()))) &&
            ((this.responseType==null && other.getResponseType()==null) || 
             (this.responseType!=null &&
              this.responseType.equals(other.getResponseType()))) &&
            ((this.valueMaps==null && other.getValueMaps()==null) || 
             (this.valueMaps!=null &&
              java.util.Arrays.equals(this.valueMaps, other.getValueMaps())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFileData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFileData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFileType() != null) {
            _hashCode += getFileType().hashCode();
        }
        if (getResponseType() != null) {
            _hashCode += getResponseType().hashCode();
        }
        if (getValueMaps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValueMaps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValueMaps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrintRequestObj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://objects.printengine.whitecoast.ch", "PrintRequestObj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://objects.printengine.whitecoast.ch", "fileData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://objects.printengine.whitecoast.ch", "fileType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://objects.printengine.whitecoast.ch", "responseType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueMaps");
        elemField.setXmlName(new javax.xml.namespace.QName("http://objects.printengine.whitecoast.ch", "valueMaps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://objects.printengine.whitecoast.ch", "ValueMap"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.printengine.whitecoast.ch", "item"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
