/**
 * PrintServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ch.whitecoast.printengine.service;

public interface PrintServiceService extends javax.xml.rpc.Service {
    public java.lang.String getPrintServiceAddress();

    public ch.whitecoast.printengine.service.PrintService getPrintService() throws javax.xml.rpc.ServiceException;

    public ch.whitecoast.printengine.service.PrintService getPrintService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
