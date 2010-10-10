/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/

/**
 * FlightStatusLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.aeroflot.www;

public class FlightStatusLocator extends org.apache.axis.client.Service implements ru.aeroflot.www.FlightStatus {

    public FlightStatusLocator() {
    }


    public FlightStatusLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FlightStatusLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FlightStatusSoap
    private java.lang.String FlightStatusSoap_address = "http://webservices.aeroflot.ru/flightstatus.asmx";

    public java.lang.String getFlightStatusSoapAddress() {
        return FlightStatusSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FlightStatusSoapWSDDServiceName = "FlightStatusSoap";

    public java.lang.String getFlightStatusSoapWSDDServiceName() {
        return FlightStatusSoapWSDDServiceName;
    }

    public void setFlightStatusSoapWSDDServiceName(java.lang.String name) {
        FlightStatusSoapWSDDServiceName = name;
    }

    public ru.aeroflot.www.FlightStatusSoap getFlightStatusSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FlightStatusSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFlightStatusSoap(endpoint);
    }

    public ru.aeroflot.www.FlightStatusSoap getFlightStatusSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.aeroflot.www.FlightStatusSoapStub _stub = new ru.aeroflot.www.FlightStatusSoapStub(portAddress, this);
            _stub.setPortName(getFlightStatusSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFlightStatusSoapEndpointAddress(java.lang.String address) {
        FlightStatusSoap_address = address;
    }


    // Use to get a proxy class for FlightStatusSoap12
    private java.lang.String FlightStatusSoap12_address = "http://webservices.aeroflot.ru/flightstatus.asmx";

    public java.lang.String getFlightStatusSoap12Address() {
        return FlightStatusSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FlightStatusSoap12WSDDServiceName = "FlightStatusSoap12";

    public java.lang.String getFlightStatusSoap12WSDDServiceName() {
        return FlightStatusSoap12WSDDServiceName;
    }

    public void setFlightStatusSoap12WSDDServiceName(java.lang.String name) {
        FlightStatusSoap12WSDDServiceName = name;
    }

    public ru.aeroflot.www.FlightStatusSoap getFlightStatusSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FlightStatusSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFlightStatusSoap12(endpoint);
    }

    public ru.aeroflot.www.FlightStatusSoap getFlightStatusSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.aeroflot.www.FlightStatusSoap12Stub _stub = new ru.aeroflot.www.FlightStatusSoap12Stub(portAddress, this);
            _stub.setPortName(getFlightStatusSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFlightStatusSoap12EndpointAddress(java.lang.String address) {
        FlightStatusSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ru.aeroflot.www.FlightStatusSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.aeroflot.www.FlightStatusSoapStub _stub = new ru.aeroflot.www.FlightStatusSoapStub(new java.net.URL(FlightStatusSoap_address), this);
                _stub.setPortName(getFlightStatusSoapWSDDServiceName());
                return _stub;
            }
            if (ru.aeroflot.www.FlightStatusSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.aeroflot.www.FlightStatusSoap12Stub _stub = new ru.aeroflot.www.FlightStatusSoap12Stub(new java.net.URL(FlightStatusSoap12_address), this);
                _stub.setPortName(getFlightStatusSoap12WSDDServiceName());
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
        if ("FlightStatusSoap".equals(inputPortName)) {
            return getFlightStatusSoap();
        }
        else if ("FlightStatusSoap12".equals(inputPortName)) {
            return getFlightStatusSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.aeroflot.ru/", "FlightStatus");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "FlightStatusSoap"));
            ports.add(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "FlightStatusSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

if ("FlightStatusSoap".equals(portName)) {
            setFlightStatusSoapEndpointAddress(address);
        }
        else
if ("FlightStatusSoap12".equals(portName)) {
            setFlightStatusSoap12EndpointAddress(address);
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
