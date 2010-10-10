/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/

/**
 * FlightStatusSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.aeroflot.www;

public interface FlightStatusSoap extends java.rmi.Remote {

    /**
     * Информация об аэропорте<br>Information on airport
     * <br><br>Входные параметры:<br>You pass following parameters to function:
     * <ul>
     * <li>code - код аэропорта<br>airport code</ul>
     * <br>Возвращается структура, состоящая из следующих полей:<br>In return,
     * you get a list of structures, consisting of following fields:
     * <ul>
     * <li>city - город<br>city of airport
     * <li>name - название аэропорта<br>airport name
     * <li>code - код аэропорта<br>airport code</ul>
     */
    public ru.aeroflot.www.Airport airportInfo(java.lang.String code) throws java.rmi.RemoteException;

    /**
     * Список аэропортов<br>Airport list
     * <br><br>Возвращается список структур, состоящих из следующих полей:<br>You
     * get a list of structures, consisting of following fields:
     * <ul>
     * <li>city - город<br>city name
     * <li>name - название аэропорта<br>airport name
     * <li>code - код аэропорта<br>airport code</ul>
     */
    public ru.aeroflot.www.Airport[] airportList() throws java.rmi.RemoteException;

    /**
     * Список дат, за которые есть данные в системе<br>Information
     * available only for dates, listed in DateList
     */
    public java.util.Calendar[] dateList() throws java.rmi.RemoteException;

    /**
     * Подробная информация о рейсе<br>Extended flight info
     * <br><br>Входные параметры:<br>You pass following parameters to function:
     * <ul>
     * <li>flt_pk - код рейса<br>flight code</ul>
     * <br>Возвращается список структур, состоящих из следующих полей:<br>In
     * return, you get a list of structures, consisting of following fields:
     * <ul>
     * <li>company - код авиакомпании<br>airline code
     * <li>flight_no - номер рейса<br>flight number
     * <li>flight_type - тип рейса<br>flight type
     * <li>aircraft_type - тип самолета<br>aircraft type
     * <li>bort - номер самолета (борта)<br>aircraft identification number
     * <li>seats_f - количество мест первого класса<br>number of 1-st class
     * seats
     * <li>seats_c - количество мест бизнес-класса<br>number of business-class
     * seats
     * <li>seats_y - количество мест эконом-класса<br>number of economy-class
     * seats
     * <li>sched_dep - время вылета по расписанию<br>scheduled departure
     * time
     * <li>sched_arr - время прибытия по расписанию<br>scheduled arrival
     * time
     * <li>plan_dep - планируемое время вылета<br>planned departure time
     * <li>plan_arr - планируемое время прибытия<br>planned arrival time
     * <li>fact_dep - фактическое время вылета<br>departure fact
     * <li>fact_arr - фактическое время прибытия<br>arrival fact
     * <li>real_dep - время взлета<br>take of time
     * <li>real_arr - время посадки<br>landing time
     * <li>calc - расчетное время прибытия<br>estimated arrival time
     * <li>status - статус рейса<br>flight status
     * <li>city_dep - город отправления<br>departure city
     * <li>airport_dep - название аеропорта отправления<br>name of departure
     * airport
     * <li>code_dep - код аэропорта отправления<br>code of departure airport
     * <li>terminal_dep - номер терминала аэропорта отправления<br>number
     * of terminal in departure airport
     * <li>city_arr - город назначения<br>arrival city
     * <li>airport_arr - название аеропорта назначения<br>name of arrival
     * airport
     * <li>code_arr - код аэропорта назначения<br>code of arrival airport
     * <li>terminal_arr - номер терминала аэропорта назначения<br>number
     * of terminal in arrival airport</ul>
     */
    public ru.aeroflot.www.FlightDetail[] flightInfo(java.lang.String flt_pk) throws java.rmi.RemoteException;

    /**
     * Табло прилета<br>Arrivals by airport
     * <br><br>Входные параметры:<br>You pass following parameters to function:
     * <ul>
     * <li>code - код аэропорта<br>airport code
     * <li>date - дата<br>date
     * <li>order_field - поле ('airport', 'sched', 'plan', 'company', 'flight_no'),
     * по которому идет сортировка<br>one of ('airport', 'sched', 'plan',
     * 'company', 'flight_no') to sort by
     * <li>order - направление сортировки ('desc', 'asc')<br>sort order ('desc',
     * 'asc')</ul>
     * <br>Возвращается список структур, состоящих из следующих полей:<br>In
     * return, you get a list of structures, consisting of following fields:
     * <ul>
     * <li>flt_pk - код рейса<br>flight code
     * <li>company - код авиакомпании<br>airline code
     * <li>flight_no - номер рейса<br>flight number
     * <li>airport_inter - название промежуточного аэропорта<br>code of transit
     * airport
     * <li>airport - название аеропорта отправления<br>departure airport
     * name
     * <li>sched - время прибытия по расписанию<br>scheduled arrival time
     * <li>plan - планируемое время прибытия<br>planned arrival time
     * <li>fact - фактическое время прибытия<br>arrival fact
     * <li>calc - расчетное время прибытия<br>estimated arrival time
     * <li>real - время посадки<br>landing time
     * <li>union_flight_no - номер, объединенного рейса<br>number of joined
     * flight
     * <li>status - статус рейса<br>flight status
     * <li>is_check - не используется<br>not used
     * <li>is_board - не используется<br>not used</ul>
     */
    public ru.aeroflot.www.Flight[] arrival(java.lang.String code, java.lang.String date, java.lang.String order_field, java.lang.String order) throws java.rmi.RemoteException;

    /**
     * Табло вылета<br>Departures by airport
     * <br><br>Входные параметры:<br>You pass following parameters to function:
     * <ul>
     * <li>code - код аэропорта<br>airport code
     * <li>date - дата<br>date
     * <li>order_field - поле ('airport', 'sched', 'plan', 'company', 'flight_no'),
     * по которому идет сортировка<br>one of ('airport', 'sched', 'plan',
     * 'company', 'flight_no') to sort by
     * <li>order - направление сортировки ('desc', 'asc')<br>sort order ('desc',
     * 'asc')</ul>
     * <br>Возвращается список структур, состоящих из следующих полей:<br>In
     * return, you get a list of structures, consisting of following fields:
     * <ul>
     * <li>flt_pk - код рейса<br>flight code
     * <li>company - код авиакомпании<br>airline code
     * <li>flight_no - номер рейса<br>flight number
     * <li>airport_inter - название промежуточного аэропорта<br>code of transit
     * airport
     * <li>airport - название аеропорта назначения<br>destination airport
     * name
     * <li>sched - время вылета по расписанию<br>scheduled departure time
     * <li>plan - планируемое время вылета<br>planned departure time
     * <li>fact - фактическое время вылета<br>departure fact
     * <li>calc - не используется<br>not used
     * <li>real - время взлета<br>take-off time
     * <li>union_flight_no - номер, объединенного рейса<br>number of joined
     * flight
     * <li>status - статус рейса<br>flight status
     * <li>is_check - признак регистрации (1 - идет, 0 - нет)<br>check-in
     * (1-on, 0-off)
     * <li>is_board - признак посадки в самолет (1 - идет, 0 - нет)<br>boarding
     * (1-on, 0-off)</ul>
     */
    public ru.aeroflot.www.Flight[] departure(java.lang.String code, java.lang.String date, java.lang.String order_field, java.lang.String order) throws java.rmi.RemoteException;

    /**
     * Поиск рейсов<br>Search for flights
     * <br><br>Входные параметры:<br>You pass following parameters to function:
     * <ul>
     * <li>flight_no - номер рейса<br>flight number</ul>
     * <br>Возвращается список структур, состоящих из следующих полей:<br>In
     * return, you get a list of structures, consisting of following fields:
     * <ul>
     * <li>flt_pk - код рейса<br>flight code
     * <li>company - код авиакомпании<br>airline code
     * <li>flight_no - номер рейса<br>flight number
     * <li>airport_dep - название аэропорта отправления<br>name of departure
     * airport
     * <li>airport_inter - название промежуточного аэропорта<br>name of transit
     * airport
     * <li>airport_arr - название аеропорта назначения<br>name of arrival
     * airport
     * <li>sched_dep - время вылета по расписанию<br>scheduled departure
     * time</ul>
     */
    public ru.aeroflot.www.FlightShort[] flightSearch(java.lang.String flight_no) throws java.rmi.RemoteException;
}
