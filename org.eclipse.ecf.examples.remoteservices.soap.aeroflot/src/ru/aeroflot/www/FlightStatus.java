/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/

/**
 * FlightStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.aeroflot.www;

public interface FlightStatus extends javax.xml.rpc.Service {
    public java.lang.String getFlightStatusSoapAddress();

    public ru.aeroflot.www.FlightStatusSoap getFlightStatusSoap() throws javax.xml.rpc.ServiceException;

    public ru.aeroflot.www.FlightStatusSoap getFlightStatusSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getFlightStatusSoap12Address();

    public ru.aeroflot.www.FlightStatusSoap getFlightStatusSoap12() throws javax.xml.rpc.ServiceException;

    public ru.aeroflot.www.FlightStatusSoap getFlightStatusSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
