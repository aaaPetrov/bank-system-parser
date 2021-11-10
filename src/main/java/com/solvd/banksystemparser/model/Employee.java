package com.solvd.banksystemparser.model;

import java.time.LocalDateTime;


public class Employee extends Human {

    public static int count = 0;
    private Currency salary;
    private String position;

    public Employee() {

    }

    public Employee(String firstName, String lastName, LocalDateTime birthDay, String position, Currency salary) {
        super(firstName, lastName, birthDay);
        this.position = position;
        this.salary = salary;
        count++;
    }

    public Currency getSalary() {
        return salary;
    }

    public void setSalary(Currency salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        String str = "\nEmployee: " + super.getFirstName() + " " + super.getLastName()
                + "\nPosition: " + position
                + "\nSalary: " + salary.getAmount() + " " + salary.getCurrencyType()
                + "\nBorn: " + super.getBirthday().getDayOfMonth() + "."
                + super.getBirthday().getMonth() + "." + super.getBirthday().getYear()
                + "\nAge: " + super.getAge();
        return str;
    }

}
