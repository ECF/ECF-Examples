/*******************************************************************************
 * Copyright (c) 2010 Naumen. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors: Pavel Samolisov - initial API and implementation
 ******************************************************************************/

/**
 * FlightShort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.aeroflot.www;

public class FlightShort  implements java.io.Serializable {
    private java.lang.String airport_arr;

    private java.lang.String airport_dep;

    private java.lang.String airport_inter;

    private java.lang.String company;

    private java.lang.String flight_no;

    private java.lang.String flt_pk;

    private java.util.Calendar sched_dep;

    public FlightShort() {
    }

    public FlightShort(
           java.lang.String airport_arr,
           java.lang.String airport_dep,
           java.lang.String airport_inter,
           java.lang.String company,
           java.lang.String flight_no,
           java.lang.String flt_pk,
           java.util.Calendar sched_dep) {
           this.airport_arr = airport_arr;
           this.airport_dep = airport_dep;
           this.airport_inter = airport_inter;
           this.company = company;
           this.flight_no = flight_no;
           this.flt_pk = flt_pk;
           this.sched_dep = sched_dep;
    }


    /**
     * Gets the airport_arr value for this FlightShort.
     *
     * @return airport_arr
     */
    public java.lang.String getAirport_arr() {
        return airport_arr;
    }


    /**
     * Sets the airport_arr value for this FlightShort.
     *
     * @param airport_arr
     */
    public void setAirport_arr(java.lang.String airport_arr) {
        this.airport_arr = airport_arr;
    }


    /**
     * Gets the airport_dep value for this FlightShort.
     *
     * @return airport_dep
     */
    public java.lang.String getAirport_dep() {
        return airport_dep;
    }


    /**
     * Sets the airport_dep value for this FlightShort.
     *
     * @param airport_dep
     */
    public void setAirport_dep(java.lang.String airport_dep) {
        this.airport_dep = airport_dep;
    }


    /**
     * Gets the airport_inter value for this FlightShort.
     *
     * @return airport_inter
     */
    public java.lang.String getAirport_inter() {
        return airport_inter;
    }


    /**
     * Sets the airport_inter value for this FlightShort.
     *
     * @param airport_inter
     */
    public void setAirport_inter(java.lang.String airport_inter) {
        this.airport_inter = airport_inter;
    }


    /**
     * Gets the company value for this FlightShort.
     *
     * @return company
     */
    public java.lang.String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this FlightShort.
     *
     * @param company
     */
    public void setCompany(java.lang.String company) {
        this.company = company;
    }


    /**
     * Gets the flight_no value for this FlightShort.
     *
     * @return flight_no
     */
    public java.lang.String getFlight_no() {
        return flight_no;
    }


    /**
     * Sets the flight_no value for this FlightShort.
     *
     * @param flight_no
     */
    public void setFlight_no(java.lang.String flight_no) {
        this.flight_no = flight_no;
    }


    /**
     * Gets the flt_pk value for this FlightShort.
     *
     * @return flt_pk
     */
    public java.lang.String getFlt_pk() {
        return flt_pk;
    }


    /**
     * Sets the flt_pk value for this FlightShort.
     *
     * @param flt_pk
     */
    public void setFlt_pk(java.lang.String flt_pk) {
        this.flt_pk = flt_pk;
    }


    /**
     * Gets the sched_dep value for this FlightShort.
     *
     * @return sched_dep
     */
    public java.util.Calendar getSched_dep() {
        return sched_dep;
    }


    /**
     * Sets the sched_dep value for this FlightShort.
     *
     * @param sched_dep
     */
    public void setSched_dep(java.util.Calendar sched_dep) {
        this.sched_dep = sched_dep;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightShort)) return false;
        FlightShort other = (FlightShort) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.airport_arr==null && other.getAirport_arr()==null) ||
             (this.airport_arr!=null &&
              this.airport_arr.equals(other.getAirport_arr()))) &&
            ((this.airport_dep==null && other.getAirport_dep()==null) ||
             (this.airport_dep!=null &&
              this.airport_dep.equals(other.getAirport_dep()))) &&
            ((this.airport_inter==null && other.getAirport_inter()==null) ||
             (this.airport_inter!=null &&
              this.airport_inter.equals(other.getAirport_inter()))) &&
            ((this.company==null && other.getCompany()==null) ||
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            ((this.flight_no==null && other.getFlight_no()==null) ||
             (this.flight_no!=null &&
              this.flight_no.equals(other.getFlight_no()))) &&
            ((this.flt_pk==null && other.getFlt_pk()==null) ||
             (this.flt_pk!=null &&
              this.flt_pk.equals(other.getFlt_pk()))) &&
            ((this.sched_dep==null && other.getSched_dep()==null) ||
             (this.sched_dep!=null &&
              this.sched_dep.equals(other.getSched_dep())));
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
        if (getAirport_arr() != null) {
            _hashCode += getAirport_arr().hashCode();
        }
        if (getAirport_dep() != null) {
            _hashCode += getAirport_dep().hashCode();
        }
        if (getAirport_inter() != null) {
            _hashCode += getAirport_inter().hashCode();
        }
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        if (getFlight_no() != null) {
            _hashCode += getFlight_no().hashCode();
        }
        if (getFlt_pk() != null) {
            _hashCode += getFlt_pk().hashCode();
        }
        if (getSched_dep() != null) {
            _hashCode += getSched_dep().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightShort.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "FlightShort"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("airport_inter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "airport_inter"));
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
        elemField.setFieldName("sched_dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aeroflot.ru/", "sched_dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
