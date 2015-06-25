/**
 * PrintServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ch.whitecoast.printengine.service;

public class PrintServiceServiceLocator extends org.apache.axis.client.Service implements ch.whitecoast.printengine.service.PrintServiceService {

    public PrintServiceServiceLocator() {
    }


    public PrintServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PrintServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PrintService
    private java.lang.String PrintService_address = "http://localhost:8080/PrintEngine/services/PrintService";

    public java.lang.String getPrintServiceAddress() {
        return PrintService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PrintServiceWSDDServiceName = "PrintService";

    public java.lang.String getPrintServiceWSDDServiceName() {
        return PrintServiceWSDDServiceName;
    }

    public void setPrintServiceWSDDServiceName(java.lang.String name) {
        PrintServiceWSDDServiceName = name;
    }

    public ch.whitecoast.printengine.service.PrintService getPrintService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PrintService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPrintService(endpoint);
    }

    public ch.whitecoast.printengine.service.PrintService getPrintService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ch.whitecoast.printengine.service.PrintServiceSoapBindingStub _stub = new ch.whitecoast.printengine.service.PrintServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPrintServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPrintServiceEndpointAddress(java.lang.String address) {
        PrintService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ch.whitecoast.printengine.service.PrintService.class.isAssignableFrom(serviceEndpointInterface)) {
                ch.whitecoast.printengine.service.PrintServiceSoapBindingStub _stub = new ch.whitecoast.printengine.service.PrintServiceSoapBindingStub(new java.net.URL(PrintService_address), this);
                _stub.setPortName(getPrintServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PrintService".equals(inputPortName)) {
            return getPrintService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.printengine.whitecoast.ch", "PrintServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.printengine.whitecoast.ch", "PrintService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PrintService".equals(portName)) {
            setPrintServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
