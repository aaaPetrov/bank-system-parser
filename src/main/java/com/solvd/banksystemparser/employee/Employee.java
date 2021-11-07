package com.solvd.banksystemparser.employee;

import com.solvd.banksystemparser.currency.Currency;
import com.solvd.banksystemparser.human.Human;
import com.solvd.banksystemparser.print.Printable;
import java.time.LocalDateTime;


public class Employee extends Human implements Printable {

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
    public void print() {
        System.out.println("Employee: " + super.getFirstName() + " " + super.getLastName());
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary.getAmount() + " " + salary.getCurrencyType());
        System.out.println("Born: " + super.getBirthday().getDayOfMonth() + "." +
                super.getBirthday().getMonth() + "." + super.getBirthday().getYear());
        System.out.println("Age: " + super.getAge());
    }

}
