/**
 * EmployeeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mypackage;

public interface EmployeeService extends java.rmi.Remote {
    public mypackage.Employee[] getListEmloyees() throws java.rmi.RemoteException;
    public mypackage.Employee createEmployee(mypackage.Employee arg0) throws java.rmi.RemoteException;
    public mypackage.Employee editEmployee(mypackage.Employee arg0) throws java.rmi.RemoteException;
    public mypackage.Employee getById(long arg0) throws java.rmi.RemoteException;
}
