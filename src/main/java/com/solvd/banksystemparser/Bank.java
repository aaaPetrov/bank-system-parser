package com.solvd.banksystemparser;

import com.solvd.banksystemparser.organization.address.Address;
import com.solvd.banksystemparser.currency.Currency;
import com.solvd.banksystemparser.employee.Employee;
import com.solvd.banksystemparser.organization.Organization;
import com.solvd.banksystemparser.print.Printable;
import java.time.LocalDateTime;
import java.util.List;

public class Bank extends Organization implements Printable {

    public static int count = 0;

    private Currency usd;
    private Currency eur;
    private Currency rub;
    private Currency byn;
    private List<Employee> employees;

    public Bank() {

    }

    public Bank(String name, Address address, LocalDateTime foundedAt) {
        super(name, address, foundedAt);
        count++;
    }

    public Bank(String nameOfBank, Address address, LocalDateTime foundedAt, Currency usd, Currency eur, Currency rub, Currency byn) {
        this(nameOfBank, address, foundedAt);
        this.usd = usd;
        this.eur = eur;
        this.rub = rub;
        this.byn = byn;
    }

    public void setUsd(Currency usd) {
        this.usd = usd;
    }

    public Currency getUsd() {
        return usd;
    }

    public void setEur(Currency eur) {
        this.eur = eur;
    }

    public Currency getEur() {
        return eur;
    }

    public void setRub(Currency rub) {
        this.rub = rub;
    }

    public Currency getRub() {
        return rub;
    }

    public void setByn(Currency byn) {
        this.byn = byn;
    }

    public Currency getByn() {
        return byn;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void print() {
        System.out.printf("%-60s%s%s", "\n", "BANK ININFORMATION:", "\n\n");
        System.out.println(super.getName() + "bank , located on " + super.getAddress().getCity() +
                " " + super.getAddress().getStreet() + " " + super.getAddress().getHouseNumber() + " street, founded in " +
                super.getFoundedAt().getDayOfMonth() + "." + super.getFoundedAt().getMonth() + "." + super.getFoundedAt().getYear());
        System.out.println("\nBank capital:");
        System.out.println(getUsd().getAmount() + " " + Currency.CurrencyType.USD);
        System.out.println(getEur().getAmount() + " " + Currency.CurrencyType.EURO);
        System.out.println(getRub().getAmount() + " " + Currency.CurrencyType.RUB);
        System.out.println(getByn().getAmount() + " " + Currency.CurrencyType.BYN);
        System.out.println("\nEmployees:");
        employees.forEach(employee -> {
            System.out.println("---------------------------");
            employee.print();
        });
    }

}