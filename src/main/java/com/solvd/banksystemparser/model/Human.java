package com.solvd.banksystemparser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Human {

    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime birthday;

    public Human() {

    }

    public Human(String firstName, String lastName, LocalDateTime birthday) {
        int age = (int) ChronoUnit.YEARS.between(birthday, LocalDateTime.now());
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.age = age;
    }

    @XmlElement(name = "firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement(name = "lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @XmlElement(name = "birthday")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        this.age = (int) ChronoUnit.YEARS.between(this.birthday, LocalDateTime.now());
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

}
