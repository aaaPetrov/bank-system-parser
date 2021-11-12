package com.solvd.banksystemparser.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Organization {

    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "address")
    private Address address;
    @XmlElement(name = "dateFounded")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("dateFounded")
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