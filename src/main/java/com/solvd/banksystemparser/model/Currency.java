package com.solvd.banksystemparser.model;

public class Currency {

    private CurrencyType currencyType;
    private double amount;

    public Currency(double moneyAmount, CurrencyType currencyType) {
            this.amount = moneyAmount;
            this.currencyType = currencyType;
    }

    public enum  CurrencyType {

        USD("USD"), EURO("EUR"), RUB("RUB"), BYN("BYN");

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

}