package com.solvd.banksystemparser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
public class Employee extends Human {

    public static int count = 0;

    @XmlElement(name = "currency")
    private Currency salary;
    @XmlElement(name = "position")
    private String position;

    public Employee() {
        count++;
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
        return "\nEmployee: " + super.getFirstName() + " " + super.getLastName()
                + "\nPosition: " + position
                + "\nSalary: " + salary.getAmount() + " " + salary.getCurrencyType()
                + "\nBorn: " + super.getBirthday().getDayOfMonth() + "."
                + super.getBirthday().getMonth() + "." + super.getBirthday().getYear()
                + "\nAge: " + super.getAge();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Employee employee = (Employee) object;
        return salary.equals(employee.getSalary())
                && (position != null && position.equals(employee.getPosition()))
                && getFirstName().equals(employee.getFirstName())
                && getLastName().equals(employee.getLastName())
                && getAge() == employee.getAge()
                && getBirthday().equals(employee.getBirthday());
    }

}
