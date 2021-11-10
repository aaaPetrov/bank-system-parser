package com.solvd.banksystemparser;

import com.solvd.banksystemparser.model.Address;
import com.solvd.banksystemparser.model.Currency;
import com.solvd.banksystemparser.model.Employee;
import com.solvd.banksystemparser.model.Organization;
import java.time.LocalDateTime;
import java.util.List;

public class Bank extends Organization{

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
    public String toString() {
        String str = super.getName() + "bank , located on " + super.getAddress().getCity()
                + " " + super.getAddress().getStreet() + " " + super.getAddress().getHouseNumber() + " street, founded in "
                + super.getFoundedAt().getDayOfMonth() + "." + super.getFoundedAt().getMonth() + "." + super.getFoundedAt().getYear() + "\n"
                + "\nBank capital:"
                + "\n" + getUsd().getAmount() + " " + Currency.CurrencyType.USD
                + "\n" + getEur().getAmount() + " " + Currency.CurrencyType.EURO
                + "\n" + getRub().getAmount() + " " + Currency.CurrencyType.RUB
                + "\n" + getByn().getAmount() + " " + Currency.CurrencyType.BYN + "\n"
                + "\nEmployees:";
        for(Employee employee : employees) {
            str += "\n---------------------------";
            str += employee;
        }
        return str;
    }

}