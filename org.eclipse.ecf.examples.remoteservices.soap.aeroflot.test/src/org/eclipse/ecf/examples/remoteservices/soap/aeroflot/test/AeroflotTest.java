/*******************************************************************************
* Copyright (c) 2010 Naumen. All rights reserved. This
* program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution, and is
* available at http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Pavel Samolisov - initial API and implementation
******************************************************************************/
package org.eclipse.ecf.examples.remoteservices.soap.aeroflot.test;

import java.util.Date;
import java.util.List;


import org.eclipse.ecf.core.ContainerFactory;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.core.util.ECFException;
import org.eclipse.ecf.examples.remoteservices.soap.aeroflot.IFlightStatusService;
import org.eclipse.ecf.remoteservice.IRemoteService;
import org.eclipse.ecf.remoteservice.IRemoteServiceContainerAdapter;
import org.eclipse.ecf.remoteservice.IRemoteServiceReference;
import org.eclipse.ecf.tests.ECFAbstractTestCase;
import org.osgi.framework.InvalidSyntaxException;

import ru.aeroflot.www.Airport;
import ru.aeroflot.www.Flight;

public class AeroflotTest extends ECFAbstractTestCase
{
    private IContainer container;

    private IRemoteServiceContainerAdapter containerAdapter;

    @Override
     protected void setUp() throws Exception
     {
        super.setUp();
         container = ContainerFactory.getDefault().createContainer("ecf.aeroflot.soap.client");
         containerAdapter = (IRemoteServiceContainerAdapter) container.getAdapter(IRemoteServiceContainerAdapter.class);
    }

    @Override
     protected void tearDown() throws Exception
     {
         super.tearDown();
         containerAdapter = null;
         container.dispose();
         container = null;
     }

    private IFlightStatusService getServiceProxy() throws InvalidSyntaxException, ECFException
    {
        IRemoteServiceReference[] refs = containerAdapter.getRemoteServiceReferences((ID) null,
                 IFlightStatusService.class.getName(), null);

         assertNotNull(refs);
         assertTrue(refs.length > 0);

         IRemoteService remoteService = containerAdapter.getRemoteService(refs[0]);

        return (IFlightStatusService) remoteService.getProxy();
    }

     public void testGetAirPortList() throws Exception
     {
         IFlightStatusService proxy = getServiceProxy();
         assertNotNull(proxy);

         // Now call it
         List<Airport> airportList = proxy.getAirPortList();
         assertNotNull(airportList);

         for (Airport airport : airportList)
             System.out.println(airport.getCode());
     }

     public void testGetAirPortInfo() throws Exception
     {
         IFlightStatusService proxy = getServiceProxy();
         assertNotNull(proxy);

         Airport airport = proxy.getAirPort("SVX");
         assertNotNull(airport);

         System.out.println(airport.getName());
     }

     public void testGetArrivalOrderByAirPort() throws Exception
     {
         IFlightStatusService proxy = getServiceProxy();
         assertNotNull(proxy);

         List<Flight> flightes = proxy.getArrivalOrderByAirPort("SVX", new Date());
         assertNotNull(flightes);

         for (Flight flight : flightes)
             System.out.println(flight.getCompany());
     }
}
