/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/

package ru.aeroflot.www;

public class FlightStatusSoapProxy implements ru.aeroflot.www.FlightStatusSoap {
  private String _endpoint = null;
  private ru.aeroflot.www.FlightStatusSoap flightStatusSoap = null;

  public FlightStatusSoapProxy() {
    _initFlightStatusSoapProxy();
  }

  public FlightStatusSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initFlightStatusSoapProxy();
  }

  private void _initFlightStatusSoapProxy() {
    try {
      flightStatusSoap = (new ru.aeroflot.www.FlightStatusLocator()).getFlightStatusSoap();
      if (flightStatusSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)flightStatusSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)flightStatusSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }

    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }

  public String getEndpoint() {
    return _endpoint;
  }

  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (flightStatusSoap != null)
      ((javax.xml.rpc.Stub)flightStatusSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

  }

  public ru.aeroflot.www.FlightStatusSoap getFlightStatusSoap() {
    if (flightStatusSoap == null)
      _initFlightStatusSoapProxy();
    return flightStatusSoap;
  }

  public ru.aeroflot.www.Airport airportInfo(java.lang.String code) throws java.rmi.RemoteException{
    if (flightStatusSoap == null)
      _initFlightStatusSoapProxy();
    return flightStatusSoap.airportInfo(code);
  }

  public ru.aeroflot.www.Airport[] airportList() throws java.rmi.RemoteException{
    if (flightStatusSoap == null)
      _initFlightStatusSoapProxy();
    return flightStatusSoap.airportList();
  }

  public java.util.Calendar[] dateList() throws java.rmi.RemoteException{
    if (flightStatusSoap == null)
      _initFlightStatusSoapProxy();
    return flightStatusSoap.dateList();
  }

  public ru.aeroflot.www.FlightDetail[] flightInfo(java.lang.String flt_pk) throws java.rmi.RemoteException{
    if (flightStatusSoap == null)
      _initFlightStatusSoapProxy();
    return flightStatusSoap.flightInfo(flt_pk);
  }

  public ru.aeroflot.www.Flight[] arrival(java.lang.String code, java.lang.String date, java.lang.String order_field, java.lang.String order) throws java.rmi.RemoteException{
    if (flightStatusSoap == null)
      _initFlightStatusSoapProxy();
    return flightStatusSoap.arrival(code, date, order_field, order);
  }

  public ru.aeroflot.www.Flight[] departure(java.lang.String code, java.lang.String date, java.lang.String order_field, java.lang.String order) throws java.rmi.RemoteException{
    if (flightStatusSoap == null)
      _initFlightStatusSoapProxy();
    return flightStatusSoap.departure(code, date, order_field, order);
  }

  public ru.aeroflot.www.FlightShort[] flightSearch(java.lang.String flight_no) throws java.rmi.RemoteException{
    if (flightStatusSoap == null)
      _initFlightStatusSoapProxy();
    return flightStatusSoap.flightSearch(flight_no);
  }


}