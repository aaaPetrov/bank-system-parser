package com.solvd.banksystemparser.model;

import java.time.LocalDateTime;

public abstract class Organization {

    private String name;
    private Address address;
    private LocalDateTime foundedAt;

    public Organization() {

    }

    public Organization(String name, Address address, LocalDateTime foundedAt) {
        this.name = name;
        this.address = address;
        this.foundedAt = foundedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setFoundedAt(LocalDateTime foundedAt) {
        this.foundedAt = foundedAt;
    }

    public LocalDateTime getFoundedAt() {
        return foundedAt;
    }

}