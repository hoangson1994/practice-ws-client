/**
 * EmployeeServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mypackage;

public interface EmployeeServiceService extends javax.xml.rpc.Service {
    public java.lang.String getEmployeeServicePortAddress();

    public mypackage.EmployeeService getEmployeeServicePort() throws javax.xml.rpc.ServiceException;

    public mypackage.EmployeeService getEmployeeServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
