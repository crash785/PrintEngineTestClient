package ch.whitecoast.printengine.service;

public class PrintServiceProxy implements ch.whitecoast.printengine.service.PrintService {
  private String _endpoint = null;
  private ch.whitecoast.printengine.service.PrintService printService = null;
  
  public PrintServiceProxy() {
    _initPrintServiceProxy();
  }
  
  public PrintServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPrintServiceProxy();
  }
  
  private void _initPrintServiceProxy() {
    try {
      printService = (new ch.whitecoast.printengine.service.PrintServiceServiceLocator()).getPrintService();
      if (printService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)printService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)printService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (printService != null)
      ((javax.xml.rpc.Stub)printService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ch.whitecoast.printengine.service.PrintService getPrintService() {
    if (printService == null)
      _initPrintServiceProxy();
    return printService;
  }
  
  public ch.whitecoast.printengine.objects.PrintResponseObj getDocument(ch.whitecoast.printengine.objects.PrintRequestObj request) throws java.rmi.RemoteException{
    if (printService == null)
      _initPrintServiceProxy();
    return printService.getDocument(request);
  }
  
  
}