/**
 * PrintService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ch.whitecoast.printengine.service;

public interface PrintService extends java.rmi.Remote {
    public ch.whitecoast.printengine.objects.PrintResponseObj getDocument(ch.whitecoast.printengine.objects.PrintRequestObj request) throws java.rmi.RemoteException;
}
