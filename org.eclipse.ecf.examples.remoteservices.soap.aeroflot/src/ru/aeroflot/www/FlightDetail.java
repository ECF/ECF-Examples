/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/

/**
 * FlightDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.aeroflot.www;

public class FlightDetail  implements java.io.Serializable {
    private java.lang.String aircraft_type;

    private java.lang.String airport_arr;

    private java.lang.String airport_dep;

    private java.lang.String bort;

    private java.util.Calendar calc;

    private java.lang.String city_arr;

    private java.lang.String city_dep;

    private java.lang.String code_arr;

    private java.lang.String code_dep;

    private java.lang.String company;

    private java.util.Calendar fact_arr;

    private java.util.Calendar fact_dep;

    private java.lang.String flight_no;

    private java.lang.String flight_type;

    private java.util.Calendar plan_arr;

    private java.util.Calendar plan_dep;

    private java.util.Calendar real_arr;

    private java.util.Calendar real_dep;

    private java.util.Calendar sched_arr;

    private java.util.Calendar sched_dep;

    private int seats_c;

    private int seats_f;

    private int seats_y;

    private java.lang.String status;

    private java.lang.String terminal_arr;

    private java.lang.String terminal_dep;

    public FlightDetail() {
    }

    public FlightDetail(
           java.lang.String aircraft_type,
           java.lang.String airport_arr,
           java.lang.String airport_dep,
           java.lang.String bort,
           java.util.Calendar calc,
           java.lang.String city_arr,
           java.lang.String city_dep,
           java.lang.String code_arr,
           java.lang.String code_dep,
           java.lang.String company,
           java.util.Calendar fact_arr,
           java.util.Calendar fact_dep,
           java.lang.String flight_no,
           java.lang.String flight_type,
           java.util.Calendar plan_arr,
           java.util.Calendar plan_dep,
           java.util.Calendar real_arr,
           java.util.Calendar real_dep,
           java.util.Calendar sched_arr,
           java.util.Calendar sched_dep,
           int seats_c,
           int seats_f,
           int seats_y,
           java.lang.String status,
           java.lang.String terminal_arr,
           java.lang.String terminal_dep) {
           this.aircraft_type = aircraft_type;
           this.airport_arr = airport_arr;
           this.airport_dep = airport_dep;
           this.bort = bort;
           this.calc = calc;
           this.city_arr = city_arr;
           this.city_dep = city_dep;
           this.code_arr = code_arr;
           this.code_dep = code_dep;
           this.company = company;
           this.fact_arr = fact_arr;
           this.fact_dep = fact_dep;
           this.flight_no = flight_no;
           this.flight_type = flight_type;
           this.plan_arr = plan_arr;
           this.plan_dep = plan_dep;
           this.real_arr = real_arr;
           this.real_dep = real_dep;
           this.sched_arr = sched_arr;
           this.sched_dep = sched_dep;
           this.seats_c = seats_c;
           this.seats_f = seats_f;
           this.seats_y = seats_y;
           this.status = status;
           this.terminal_arr = terminal_arr;
           this.terminal_dep = terminal_dep;
    }


    /**
     * Gets the aircraft_type value for this FlightDetail.
     *
     * @return aircraft_type
     */
    public java.lang.String getAircraft_type() {
        return aircraft_type;
    }


    /**
     * Sets the aircraft_type value for this FlightDetail.
     *
     * @param aircraft_type
     */
    public void setAircraft_type(java.lang.String aircraft_type) {
        this.aircraft_type = aircraft_type;
    }


    /**
     * Gets the airport_arr value for this FlightDetail.
     *
     * @return airport_arr
     */
    public java.lang.String getAirport_arr() {
        return airport_arr;
    }


    /**
     * Sets the airport_arr value for this FlightDetail.
     *
     * @param airport_arr
     */
    public void setAirport_arr(java.lang.String airport_arr) {
        this.airport_arr = airport_arr;
    }


    /**
     * Gets the airport_dep value for this FlightDetail.
     *
     * @return airport_dep
     */
    public java.lang.String getAirport_dep() {
        return airport_dep;
    }


    /**
     * Sets the airport_dep value for this FlightDetail.
     *
     * @param airport_dep
     */
    public void setAirport_dep(java.lang.String airport_dep) {
        this.airport_dep = airport_dep;
    }


    /**
     * Gets the bort value for this FlightDetail.
     *
     * @return bort
     */
    public java.lang.String getBort() {
        return bort;
    }


    /**
     * Sets the bort value for this FlightDetail.
     *
     * @param bort
     */
    public void setBort(java.lang.String bort) {
        this.bort = bort;
    }


    /**
     * Gets the calc value for this FlightDetail.
     *
     * @return calc
     */
    public java.util.Calendar getCalc() {
        return calc;
    }


    /**
     * Sets the calc value for this FlightDetail.
     *
     * @param calc
     */
    public void setCalc(java.util.Calendar calc) {
        this.calc = calc;
    }


    /**
     * Gets the city_arr value for this FlightDetail.
     *
     * @return city_arr
     */
    public java.lang.String getCity_arr() {
        return city_arr;
    }


    /**
     * Sets the city_arr value for this FlightDetail.
     *
     * @param city_arr
     */
    public void setCity_arr(java.lang.String city_arr) {
        this.city_arr = city_arr;
    }


    /**
     * Gets the city_dep value for this FlightDetail.
     *
     * @return city_dep
     */
    public java.lang.String getCity_dep() {
        return city_dep;
    }


    /**
     * Sets the city_dep value for this FlightDetail.
     *
     * @param city_dep
     */
    public void setCity_dep(java.lang.String city_dep) {
        this.city_dep = city_dep;
    }


    /**
     * Gets the code_arr value for this FlightDetail.
     *
     * @return code_arr
     */
    public java.lang.String getCode_arr() {
        return code_arr;
    }


    /**
     * Sets the code_arr value for this FlightDetail.
     *
     * @param code_arr
     */
    public void setCode_arr(java.lang.String code_arr) {
        this.code_arr = code_arr;
    }


    /**
     * Gets the code_dep value for this FlightDetail.
     *
     * @return code_dep
     */
    public java.lang.String getCode_dep() {
        return code_dep;
    }


    /**
     * Sets the code_dep value for this FlightDetail.
     *
     * @param code_dep
     */
    public void setCode_dep(java.lang.String code_dep) {
        this.code_dep = code_dep;
    }


    /**
     * Gets the company value for this FlightDetail.
     *
     * @return company
     */
    public java.lang.String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this FlightDetail.
     *
     * @param company
     */
    public void setCompany(java.lang.String company) {
        this.company = company;
    }


    /**
     * Gets the fact_arr value for this FlightDetail.
     *
     * @return fact_arr
     */
    public java.util.Calendar getFact_arr() {
        return fact_arr;
    }


    /**
     * Sets the fact_arr value for this FlightDetail.
     *
     * @param fact_arr
     */
    public void setFact_arr(java.util.Calendar fact_arr) {
        this.fact_arr = fact_arr;
    }


    /**
     * Gets the fact_dep value for this FlightDetail.
     *
     * @return fact_dep
     */
    public java.util.Calendar getFact_dep() {
        return fact_dep;
    }


    /**
     * Sets the fact_dep value for this FlightDetail.
     *
     * @param fact_dep
     */
    public void setFact_dep(java.util.Calendar fact_dep) {
        this.fact_dep = fact_dep;
    }


    /**
     * Gets the flight_no value for this FlightDetail.
     *
     * @return flight_no
     */
    public java.lang.String getFlight_no() {
        return flight_no;
    }


    /**
     * Sets the flight_no value for this FlightDetail.
     *
     * @param flight_no
     */
    public void setFlight_no(java.lang.String flight_no) {
        this.flight_no = flight_no;
    }


    /**
     * Gets the flight_type value for this FlightDetail.
     *
     * @return flight_type
     */
    public java.lang.String getFlight_type() {
        return flight_type;
    }


    /**
     * Sets the flight_type value for this FlightDetail.
     *
     * @param flight_type
     */
    public void setFlight_type(java.lang.String flight_type) {
        this.flight_type = flight_type;
    }


    /**
     * Gets the plan_arr value for this FlightDetail.
     *
     * @return plan_arr
     */
    public java.util.Calendar getPlan_arr() {
        return plan_arr;
    }


    /**
     * Sets the plan_arr value for this FlightDetail.
     *
     * @param plan_arr
     */
    public void setPlan_arr(java.util.Calendar plan_arr) {
        this.plan_arr = plan_arr;
    }


    /**
     * Gets the plan_dep value for this FlightDetail.
     *
     * @return plan_dep
     */
    public java.util.Calendar getPlan_dep() {
        return plan_dep;
    }


    /**
     * Sets the plan_dep value for this FlightDetail.
     *
     * @param plan_dep
     */
    public void setPlan_dep(java.util.Calendar plan_dep) {
        this.plan_dep = plan_dep;
    }


    /**
     * Gets the real_arr value for this FlightDetail.
     *
     * @return real_arr
     */
    public java.util.Calendar getReal_arr() {
        return real_arr;
    }


    /**
     * Sets the real_arr value for this FlightDetail.
     *
     * @param real_arr
     */
    public void setReal_arr(java.util.Calendar real_arr) {
        this.real_arr = real_arr;
    }


    /**
     * Gets the real_dep value for this FlightDetail.
     *
     * @return real_dep
     */
    public java.util.Calendar getReal_dep() {
        return real_dep;
    }


    /**
     * Sets the real_dep value for this FlightDetail.
     *
     * @param real_dep
     */
    public void setReal_dep(java.util.Calendar real_dep) {
        this.real_dep = real_dep;
    }


    /**
     * Gets the sched_arr value for this FlightDetail.
     *
     * @return sched_arr
     */
    public java.util.Calendar getSched_arr() {
        return sched_arr;
    }


    /**
     * Sets the sched_arr value for this FlightDetail.
     *
     * @param sched_arr
     */
    public void setSched_arr(java.util.Calendar sched_arr) {
        this.sched_arr = sched_arr;
    }


    /**
     * Gets the sched_dep value for this FlightDetail.
     *
     * @return sched_dep
     */
    public java.util.Calendar getSched_dep() {
        return sched_dep;
    }


    /**
     * Sets the sched_dep value for this FlightDetail.
     *
     * @param sched_dep
     */
    public void setSched_dep(java.util.Calendar sched_dep) {
        this.sched_dep = sched_dep;
    }


    /**
     * Gets the seats_c value for this FlightDetail.
     *
     * @return seats_c
     */
    public int getSeats_c() {
        return seats_c;
    }


    /**
     * Sets the seats_c value for this FlightDetail.
     *
     * @param seats_c
     */
    public void setSeats_c(int seats_c) {
        this.seats_c = seats_c;
    }


    /**
     * Gets the seats_f value for this FlightDetail.
     *
     * @return seats_f
     */
    public int getSeats_f() {
        return seats_f;
    }


    /**
     * Sets the seats_f value for this FlightDetail.
     *
     * @param seats_f
     */
    public void setSeats_f(int seats_f) {
        this.seats_f = seats_f;
    }


    /**
     * Gets the seats_y value for this FlightDetail.
     *
     * @return seats_y
     */
    public int getSeats_y() {
        return seats_y;
    }


    /**
     * Sets the seats_y value for this FlightDetail.
     *
     * @param seats_y
     */
    public void setSeats_y(int seats_y) {
        this.seats_y = seats_y;
    }


    /**
     * Gets the status value for this FlightDetail.
     *
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this FlightDetail.
     *
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the terminal_arr value for this FlightDetail.
     *
     * @return terminal_arr
     */
    public java.lang.String getTerminal_arr() {
        return terminal_arr;
    }


    /**
     * Sets the terminal_arr value for this FlightDetail.
     *
     * @param terminal_arr
     */
    public void setTerminal_arr(java.lang.String terminal_arr) {
        this.terminal_arr = terminal_arr;
    }


    /**
     * Gets the terminal_dep value for this FlightDetail.
     *
     * @return terminal_dep
     */
    public java.lang.String getTerminal_dep() {
        return terminal_dep;
    }


    /**
     * Sets the terminal_dep value for this FlightDetail.
     *
     * @param terminal_dep
     */
    public void setTerminal_dep(java.lang.String terminal_dep) {
        this.terminal_dep = terminal_dep;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightDetail)) return false;
        FlightDetail other = (FlightDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.aircraft_type==null && other.getAircraft_type()==null) ||
             (this.aircraft_type!=null &&
              this.aircraft_type.equals(other.getAircraft_type()))) &&
            ((this.airport_arr==null && other.getAirport_arr()==null) ||
             (this.airport_arr!=null &&
              this.airport_arr.equals(other.getAirport_arr()))) &&
            ((this.airport_dep==null && other.getAirport_dep()==null) ||
             (this.airport_dep!=null &&
              this.airport_dep.equals(other.getAirport_dep()))) &&
            ((this.bort==null && other.getBort()==null) ||
             (this.bort!=null &&
              this.bort.equals(other.getBort()))) &&
            ((this.calc==null && other.getCalc()==null) ||
             (this.calc!=null &&
              this.calc.equals(other.getCalc()))) &&
            ((this.city_arr==null && other.getCity_arr()==null) ||
             (this.city_arr!=null &&
              this.city_arr.equals(other.getCity_arr()))) &&
            ((this.city_dep==null && other.getCity_dep()==null) ||
             (this.city_dep!=null &&
              this.city_dep.equals(other.getCity_dep()))) &&
            ((this.code_arr==null && other.getCode_arr()==null) ||
             (this.code_arr!=null &&
              this.code_arr.equals(other.getCode_arr()))) &&
            ((this.code_dep==null && other.getCode_dep()==null) ||
             (this.code_dep!=null &&
              this.code_dep.equals(other.getCode_dep()))) &&
            ((this.company==null && other.getCompany()==null) ||
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            ((this.fact_arr==null && other.getFact_arr()==null) ||
             (this.fact_arr!=null &&
              this.fact_arr.equals(other.getFact_arr()))) &&
            ((this.fact_dep==null && other.getFact_dep()==null) ||
             (this.fact_dep!=null &&
              this.fact_dep.equals(other.getFact_dep()))) &&
            ((this.flight_no==null && other.getFlight_no()==null) ||
             (this.flight_no!=null &&
              this.flight_no.equals(other.getFlight_no()))) &&
            ((this.flight_type==null && other.getFlight_type()==null) ||
             (this.flight_type!=null &&
              this.flight_type.equals(other.getFlight_type()))) &&
            ((this.plan_arr==null && other.getPlan_arr()==null) ||
             (this.plan_arr!=null &&
              this.plan_arr.equals(other.getPlan_arr()))) &&
            ((this.plan_dep==null && other.getPlan_dep()==null) ||
             (this.plan_dep!=null &&
              this.plan_dep.equals(other.getPlan_dep()))) &&
            ((this.real_arr==null && other.getReal_arr()==null) ||
             (this.real_arr!=null &&
              this.real_arr.equals(other.getReal_arr()))) &&
            ((this.real_dep==null && other.getReal_dep()==null) ||
             (this.real_dep!=null &&
              this.real_dep.equals(other.getReal_dep()))) &&
            ((this.sched_arr==null && other.getSched_arr()==null) ||
             (this.sched_arr!=null &&
              this.sched_arr.equals(other.getSched_arr()))) &&
            ((this.sched_dep==null && other.getSched_dep()==null) ||
             (this.sched_dep!=null &&
              this.sched_dep.equals(other.getSched_dep()))) &&
            this.seats_c == other.getSeats_c() &&
            this.seats_f == other.getSeats_f() &&
            this.seats_y == other.getSeats_y() &&
            ((this.status==null && other.getStatus()==null) ||
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.terminal_arr==null && other.getTerminal_arr()==null) ||
             (this.terminal_arr!=null &&
              this.terminal_arr.equals(other.getTerminal_arr()))) &&
            ((this.terminal_dep==null && other.getTerminal_dep()==null) ||
             (this.terminal_dep!=null &&
              this.terminal_dep.equals(other.getTerminal_dep())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAircraft_type() != null) {
            _hashCode += getAircraft_type().hashCode();
        }
        if (getAirport_arr() != null) {
            _hashCode += getAirport_arr().hashCode();
        }
        if (getAirport_dep() != null) {
            _hashCode += getAirport_dep().hashCode();
        }
        if (getBort() != null) {
            _hashCode += getBort().hashCode();
        }
        if (getCalc() != null) {
            _hashCode += getCalc().hashCode();
        }
        if (getCity_arr() != null) {
            _hashCode += getCity_arr().hashCode();
        }
        if (getCity_dep() != null) {
            _hashCode += getCity_dep().hashCode();
        }
        if (getCode_arr() != null) {
            _hashCode += getCode_arr().hashCode();
        }
        if (getCode_dep() != null) {
            _hashCode += getCode_dep().hashCode();
        }
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        if (getFact_arr() != null) {
            _hashCode += getFact_arr().hashCode();
        }
        if (getFact_dep() != null) {
            _hashCode += getFact_dep().hashCode();
        }
        if (getFlight_no() != null) {
            _hashCode += getFlight_no().hashCode();
        }
        if (getFlight_type() != null) {
            _hashCode += getFlight_type().hashCode();
        }
        if (getPlan_arr() != null) {
            _hashCode += getPlan_arr().hashCode();
        }
        if (getPlan_dep() != null) {
            _hashCode += getPlan_dep().hashCode();
        }
        if (getReal_arr() != null) {
            _hashCode += getReal_arr().hashCode();
        }
        if (getReal_dep() != null) {
            _hashCode += getReal_dep().hashCode();
        }
        if (getSched_arr() != null) {
            _hashCode += getSched_arr().hashCode();
        }
        if (getSched_dep() != null) {
            _hashCode += getSched_dep().hashCode();
        }
        _hashCode += getSeats_c();
        _hashCode += getSeats_f();
        _hashCode += getSeats_y();
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getTerminal_arr() != null) {
            _hashCode += getTerminal_arr().hashCode();
        }
        if (getTerminal_dep() != null) {
            _hashCode += getTerminal_dep().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "FlightDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aircraft_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "aircraft_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airport_arr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "airport_arr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airport_dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "airport_dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bort");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "bort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "calc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city_arr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "city_arr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city_dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "city_dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code_arr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "code_arr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code_dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "code_dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("company");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fact_arr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "fact_arr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fact_dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "fact_dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flight_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "flight_no"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flight_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "flight_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plan_arr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "plan_arr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plan_dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "plan_dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("real_arr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "real_arr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("real_dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "real_dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sched_arr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "sched_arr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sched_dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "sched_dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seats_c");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "seats_c"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seats_f");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "seats_f"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seats_y");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "seats_y"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminal_arr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "terminal_arr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminal_dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "terminal_dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType,
           java.lang.Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType,
           java.lang.Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
