/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/

/**
 * Flight.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.aeroflot.www;

public class Flight  implements java.io.Serializable {
    private java.lang.String airport;

    private java.lang.String airport_inter;

    private java.util.Calendar calc;

    private java.lang.String company;

    private java.util.Calendar fact;

    private java.lang.String flight_no;

    private java.lang.String flt_pk;

    private int is_board;

    private int is_check;

    private java.util.Calendar plan;

    private java.util.Calendar real;

    private java.util.Calendar sched;

    private java.lang.String status;

    private java.lang.String union_flight_no;

    public Flight() {
    }

    public Flight(
           java.lang.String airport,
           java.lang.String airport_inter,
           java.util.Calendar calc,
           java.lang.String company,
           java.util.Calendar fact,
           java.lang.String flight_no,
           java.lang.String flt_pk,
           int is_board,
           int is_check,
           java.util.Calendar plan,
           java.util.Calendar real,
           java.util.Calendar sched,
           java.lang.String status,
           java.lang.String union_flight_no) {
           this.airport = airport;
           this.airport_inter = airport_inter;
           this.calc = calc;
           this.company = company;
           this.fact = fact;
           this.flight_no = flight_no;
           this.flt_pk = flt_pk;
           this.is_board = is_board;
           this.is_check = is_check;
           this.plan = plan;
           this.real = real;
           this.sched = sched;
           this.status = status;
           this.union_flight_no = union_flight_no;
    }


    /**
     * Gets the airport value for this Flight.
     *
     * @return airport
     */
    public java.lang.String getAirport() {
        return airport;
    }


    /**
     * Sets the airport value for this Flight.
     *
     * @param airport
     */
    public void setAirport(java.lang.String airport) {
        this.airport = airport;
    }


    /**
     * Gets the airport_inter value for this Flight.
     *
     * @return airport_inter
     */
    public java.lang.String getAirport_inter() {
        return airport_inter;
    }


    /**
     * Sets the airport_inter value for this Flight.
     *
     * @param airport_inter
     */
    public void setAirport_inter(java.lang.String airport_inter) {
        this.airport_inter = airport_inter;
    }


    /**
     * Gets the calc value for this Flight.
     *
     * @return calc
     */
    public java.util.Calendar getCalc() {
        return calc;
    }


    /**
     * Sets the calc value for this Flight.
     *
     * @param calc
     */
    public void setCalc(java.util.Calendar calc) {
        this.calc = calc;
    }


    /**
     * Gets the company value for this Flight.
     *
     * @return company
     */
    public java.lang.String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this Flight.
     *
     * @param company
     */
    public void setCompany(java.lang.String company) {
        this.company = company;
    }


    /**
     * Gets the fact value for this Flight.
     *
     * @return fact
     */
    public java.util.Calendar getFact() {
        return fact;
    }


    /**
     * Sets the fact value for this Flight.
     *
     * @param fact
     */
    public void setFact(java.util.Calendar fact) {
        this.fact = fact;
    }


    /**
     * Gets the flight_no value for this Flight.
     *
     * @return flight_no
     */
    public java.lang.String getFlight_no() {
        return flight_no;
    }


    /**
     * Sets the flight_no value for this Flight.
     *
     * @param flight_no
     */
    public void setFlight_no(java.lang.String flight_no) {
        this.flight_no = flight_no;
    }


    /**
     * Gets the flt_pk value for this Flight.
     *
     * @return flt_pk
     */
    public java.lang.String getFlt_pk() {
        return flt_pk;
    }


    /**
     * Sets the flt_pk value for this Flight.
     *
     * @param flt_pk
     */
    public void setFlt_pk(java.lang.String flt_pk) {
        this.flt_pk = flt_pk;
    }


    /**
     * Gets the is_board value for this Flight.
     *
     * @return is_board
     */
    public int getIs_board() {
        return is_board;
    }


    /**
     * Sets the is_board value for this Flight.
     *
     * @param is_board
     */
    public void setIs_board(int is_board) {
        this.is_board = is_board;
    }


    /**
     * Gets the is_check value for this Flight.
     *
     * @return is_check
     */
    public int getIs_check() {
        return is_check;
    }


    /**
     * Sets the is_check value for this Flight.
     *
     * @param is_check
     */
    public void setIs_check(int is_check) {
        this.is_check = is_check;
    }


    /**
     * Gets the plan value for this Flight.
     *
     * @return plan
     */
    public java.util.Calendar getPlan() {
        return plan;
    }


    /**
     * Sets the plan value for this Flight.
     *
     * @param plan
     */
    public void setPlan(java.util.Calendar plan) {
        this.plan = plan;
    }


    /**
     * Gets the real value for this Flight.
     *
     * @return real
     */
    public java.util.Calendar getReal() {
        return real;
    }


    /**
     * Sets the real value for this Flight.
     *
     * @param real
     */
    public void setReal(java.util.Calendar real) {
        this.real = real;
    }


    /**
     * Gets the sched value for this Flight.
     *
     * @return sched
     */
    public java.util.Calendar getSched() {
        return sched;
    }


    /**
     * Sets the sched value for this Flight.
     *
     * @param sched
     */
    public void setSched(java.util.Calendar sched) {
        this.sched = sched;
    }


    /**
     * Gets the status value for this Flight.
     *
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Flight.
     *
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the union_flight_no value for this Flight.
     *
     * @return union_flight_no
     */
    public java.lang.String getUnion_flight_no() {
        return union_flight_no;
    }


    /**
     * Sets the union_flight_no value for this Flight.
     *
     * @param union_flight_no
     */
    public void setUnion_flight_no(java.lang.String union_flight_no) {
        this.union_flight_no = union_flight_no;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Flight)) return false;
        Flight other = (Flight) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.airport==null && other.getAirport()==null) ||
             (this.airport!=null &&
              this.airport.equals(other.getAirport()))) &&
            ((this.airport_inter==null && other.getAirport_inter()==null) ||
             (this.airport_inter!=null &&
              this.airport_inter.equals(other.getAirport_inter()))) &&
            ((this.calc==null && other.getCalc()==null) ||
             (this.calc!=null &&
              this.calc.equals(other.getCalc()))) &&
            ((this.company==null && other.getCompany()==null) ||
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            ((this.fact==null && other.getFact()==null) ||
             (this.fact!=null &&
              this.fact.equals(other.getFact()))) &&
            ((this.flight_no==null && other.getFlight_no()==null) ||
             (this.flight_no!=null &&
              this.flight_no.equals(other.getFlight_no()))) &&
            ((this.flt_pk==null && other.getFlt_pk()==null) ||
             (this.flt_pk!=null &&
              this.flt_pk.equals(other.getFlt_pk()))) &&
            this.is_board == other.getIs_board() &&
            this.is_check == other.getIs_check() &&
            ((this.plan==null && other.getPlan()==null) ||
             (this.plan!=null &&
              this.plan.equals(other.getPlan()))) &&
            ((this.real==null && other.getReal()==null) ||
             (this.real!=null &&
              this.real.equals(other.getReal()))) &&
            ((this.sched==null && other.getSched()==null) ||
             (this.sched!=null &&
              this.sched.equals(other.getSched()))) &&
            ((this.status==null && other.getStatus()==null) ||
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.union_flight_no==null && other.getUnion_flight_no()==null) ||
             (this.union_flight_no!=null &&
              this.union_flight_no.equals(other.getUnion_flight_no())));
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
        if (getAirport() != null) {
            _hashCode += getAirport().hashCode();
        }
        if (getAirport_inter() != null) {
            _hashCode += getAirport_inter().hashCode();
        }
        if (getCalc() != null) {
            _hashCode += getCalc().hashCode();
        }
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        if (getFact() != null) {
            _hashCode += getFact().hashCode();
        }
        if (getFlight_no() != null) {
            _hashCode += getFlight_no().hashCode();
        }
        if (getFlt_pk() != null) {
            _hashCode += getFlt_pk().hashCode();
        }
        _hashCode += getIs_board();
        _hashCode += getIs_check();
        if (getPlan() != null) {
            _hashCode += getPlan().hashCode();
        }
        if (getReal() != null) {
            _hashCode += getReal().hashCode();
        }
        if (getSched() != null) {
            _hashCode += getSched().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getUnion_flight_no() != null) {
            _hashCode += getUnion_flight_no().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Flight.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "Flight"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "airport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airport_inter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "airport_inter"));
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
        elemField.setFieldName("company");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fact");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "fact"));
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
        elemField.setFieldName("flt_pk");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "flt_pk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_board");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "is_board"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_check");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "is_check"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "plan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("real");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "real"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sched");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "sched"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("union_flight_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "union_flight_no"));
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
