package com.solvd.banksystemparser.organization.address;

import com.solvd.banksystemparser.print.Printable;

public class Address implements Printable {

    private String city;
    private String street;
    private int houseNumber;

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
    public void print() {
        System.out.println("Address: " + city + ", " + street + " " + houseNumber);
    }

}
