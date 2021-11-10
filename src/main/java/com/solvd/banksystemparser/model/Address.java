package com.solvd.banksystemparser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "street")
    private String street;
    @XmlElement(name = "houseNumber")
    private int houseNumber;

    public Address() {

    }

    public Address(String city, String street, int houseNumber) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Address address = (Address) object;
        return houseNumber == address.getHouseNumber() &&
                (city != null && city.equals(address.getCity()))
                && (street != null && street.equals(address.getStreet()));
    }

}
