package com.solvd.banksystemparser.employee;

import com.solvd.banksystemparser.currency.Currency;
import com.solvd.banksystemparser.human.Human;
import com.solvd.banksystemparser.print.Printable;
import java.time.LocalDateTime;


public class Employee extends Human implements Printable {

    public static int count = 0;
    private final Currency salary;
    private final String position;

    public Employee(String firstName, String lastName, LocalDateTime birthDay, String position, Currency salary) {
        super(firstName, lastName, birthDay);
        this.position = position;
        this.salary = salary;
        count++;
    }

    public String getPosition() {
        return position;
    }

    public Currency getSalary() {
        return salary;
    }

    @Override
    public void print() {
        System.out.println("Employee: " + super.getLastName() + " " + super.getFirstName());
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary.getAmount() + " " + salary.getCurrencyType());
        System.out.println("Born: " + super.getBirthday().getDayOfMonth() + "." +
                super.getBirthday().getMonth() + "." + super.getBirthday().getYear());
        System.out.println("Age: " + super.getAge());
    }

}
