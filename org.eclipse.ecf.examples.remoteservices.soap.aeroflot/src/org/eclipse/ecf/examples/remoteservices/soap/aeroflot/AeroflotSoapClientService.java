/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.examples.remoteservices.soap.aeroflot;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.xml.rpc.ServiceException;

import org.eclipse.ecf.core.util.ECFException;
import org.eclipse.ecf.remoteservice.IRemoteCall;
import org.eclipse.ecf.remoteservice.client.AbstractClientContainer;
import org.eclipse.ecf.remoteservice.client.IRemoteCallable;
import org.eclipse.ecf.remoteservice.client.RemoteServiceClientRegistration;
import org.eclipse.ecf.remoteservice.soap.client.AbstractSoapClientService;

import ru.aeroflot.www.FlightStatusLocator;

public class AeroflotSoapClientService extends AbstractSoapClientService
{
    public AeroflotSoapClientService(AbstractClientContainer container, RemoteServiceClientRegistration registration)
    {
        super(container, registration);
    }

    @Override
    protected Object invokeRemoteCall(IRemoteCall call, IRemoteCallable callable) throws ECFException
    {
        // Dispatch methods by names
        if (AeroflotSoapClientContainer.AIRPORT_LIST_METHOD.equals(callable.getMethod()))
        {
            // Setup and make remote call via axis client
            try
            {
                // Now make blocking remote call
                return Arrays.asList(new FlightStatusLocator().getFlightStatusSoap12().airportList());
            }
            catch (ServiceException e)
            {
                handleInvokeException("Exception setting up SOAP call", e);
            }
            catch (RemoteException e)
            {
                handleInvokeException("Exception setting up SOAP call", e);
            }
        }
        else if (AeroflotSoapClientContainer.AIRPORT_INFO_METHOD.equals(callable.getMethod()))
        {
            try
            {
                return new FlightStatusLocator().getFlightStatusSoap12().airportInfo((String) call.getParameters()[0]);
            }
            catch (ServiceException e)
            {
                handleInvokeException("Exception setting up SOAP call", e);
            }
            catch (RemoteException e)
            {
                handleInvokeException("Exception setting up SOAP call", e);
            }
        }
        else if (AeroflotSoapClientContainer.ARRIVAL_BY_AIRPORT_METHOD.equals(callable.getMethod()))
        {
            try
            {
                return Arrays.asList(new FlightStatusLocator().getFlightStatusSoap12().arrival(
                        (String) call.getParameters()[0],
                        DateFormat.getDateInstance(DateFormat.SHORT).format((Date) call.getParameters()[1]),
                        "airport",
                        "asc"));
            }
            catch (ServiceException e)
            {
                handleInvokeException("Exception setting up SOAP call", e);
            }
            catch (RemoteException e)
            {
                handleInvokeException("Exception setting up SOAP call", e);
            }
        }

        throw new ECFException("invalid method");
    }
}
