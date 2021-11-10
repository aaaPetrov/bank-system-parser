package com.solvd.banksystemparser.model;

import javax.xml.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Bank extends Organization {

    public static int count = 0;

    @XmlElement(name = "currency1")
    private Currency usd;
    @XmlElement(name = "currency2")
    private Currency eur;
    @XmlElement(name = "currency3")
    private Currency rub;
    @XmlElement(name = "currency4")
    private Currency byn;
    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employees;

    public Bank() {
        count++;
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
                + "\n" + getEur().getAmount() + " " + Currency.CurrencyType.EUR
                + "\n" + getRub().getAmount() + " " + Currency.CurrencyType.RUB
                + "\n" + getByn().getAmount() + " " + Currency.CurrencyType.BYN + "\n"
                + "\nEmployees:";
        for (Employee employee : employees) {
            str += "\n---------------------------";
            str += employee;
        }
        return str;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Bank bank = (Bank) object;
        boolean result = usd.equals(bank.getUsd()) && eur.equals(bank.getEur()) && rub.equals(bank.getRub())
                && byn.equals(bank.getByn()) && (getName() != null && getName().equals(bank.getName()))
                && getAddress().equals(bank.getAddress()) && getFoundedAt().equals(bank.getFoundedAt());
        int counter = 0;
        boolean result1 = false;
        for (int i = 0; i < this.getEmployees().size(); i++) {
            if (bank.getEmployees().get(i).equals(this.getEmployees().get(i))) {
                counter++;
                if (counter == this.getEmployees().size()) {
                    result1 = true;
                }
            } else {
                result1 = false;
            }
        }
        return result && result1;
    }
}