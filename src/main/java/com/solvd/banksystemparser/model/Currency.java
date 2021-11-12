package com.solvd.banksystemparser.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Currency {

    @XmlAttribute(name = "currencyType")
    private CurrencyType currencyType;
    @XmlValue
    private double amount;

    public Currency() {
    }

    public Currency(double moneyAmount, CurrencyType currencyType) {
        this.amount = moneyAmount;
        this.currencyType = currencyType;
    }

    public enum CurrencyType {

        USD("USD"), EUR("EUR"), RUB("RUB"), BYN("BYN");

        private final String type;

        CurrencyType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }

    public void setAmount(double moneyAmount) {
        this.amount = moneyAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Currency currency = (Currency) object;
        return amount == currency.getAmount() && (currencyType != null && currencyType.equals(currency.getCurrencyType()));
    }

}
