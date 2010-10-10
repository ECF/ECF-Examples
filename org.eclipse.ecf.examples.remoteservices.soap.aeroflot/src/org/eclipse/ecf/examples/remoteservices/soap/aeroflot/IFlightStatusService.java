/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.examples.remoteservices.soap.aeroflot;

import java.util.Date;
import java.util.List;

import ru.aeroflot.www.Airport;
import ru.aeroflot.www.Flight;

public interface IFlightStatusService
{
    List<Airport> getAirPortList();

    Airport getAirPort(String code);

    List<Flight> getArrivalOrderByAirPort(String airportCode, Date date);
}
