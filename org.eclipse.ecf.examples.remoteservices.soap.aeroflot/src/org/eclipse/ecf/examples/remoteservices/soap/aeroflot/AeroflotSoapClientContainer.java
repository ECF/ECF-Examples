/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.examples.remoteservices.soap.aeroflot;

import org.eclipse.ecf.remoteservice.IRemoteService;
import org.eclipse.ecf.remoteservice.client.IRemoteCallable;
import org.eclipse.ecf.remoteservice.client.RemoteServiceClientRegistration;
import org.eclipse.ecf.remoteservice.soap.client.AbstractSoapClientContainer;
import org.eclipse.ecf.remoteservice.soap.client.SoapCallableFactory;
import org.eclipse.ecf.remoteservice.soap.identity.SoapID;

public class AeroflotSoapClientContainer extends AbstractSoapClientContainer
{
    public static final String AIRPORT_LIST_METHOD = "getAirPortList";

    public static final String AIRPORT_INFO_METHOD = "getAirPort";

    public static final String ARRIVAL_BY_AIRPORT_METHOD = "getArrivalOrderByAirPort";

    public AeroflotSoapClientContainer(SoapID containerID)
    {
        super(containerID);

        // Create a callable that has the single 'AirportList' method
        IRemoteCallable[][] callables = new IRemoteCallable[][] {
                { SoapCallableFactory.createCallable(AIRPORT_LIST_METHOD),
                  SoapCallableFactory.createCallable(AIRPORT_INFO_METHOD),
                  SoapCallableFactory.createCallable(ARRIVAL_BY_AIRPORT_METHOD)}
        };

        // Register it
        registerCallables(new String[] { IFlightStatusService.class.getName() }, callables, null);
    }

    @Override
    protected IRemoteService createRemoteService(RemoteServiceClientRegistration registration)
    {
        // Return our service
        return new AeroflotSoapClientService(this, registration);
    }
}
