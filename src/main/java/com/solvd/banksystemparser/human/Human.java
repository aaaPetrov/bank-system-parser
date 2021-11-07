package com.solvd.banksystemparser.human;

import com.solvd.banksystemparser.print.Printable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Human implements Printable {

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

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

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    @Override
    public void print() {
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Born: " + birthday);
        System.out.println("Age: " + age);
    }

}
