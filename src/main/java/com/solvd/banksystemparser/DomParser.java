package com.solvd.banksystemparser;

import com.solvd.banksystemparser.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements IParse {

    @Override
    public BankData parse(String pathname) throws ParserConfigurationException, IOException, SAXException {
        List<Bank> banks = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document document;
        document = builder.parse(new File(pathname));
        NodeList banksChild = document.getDocumentElement().getElementsByTagName("bank");
        setBanks(banksChild, banks);
        BankData bankData = new BankData();
        bankData.setBanks(banks);
        return bankData;
    }

    public static void setBanks(NodeList banksChild, List<Bank> banks) {
        for (int i = 0; i < banksChild.getLength(); i++) {
            Node bankdataChild = banksChild.item(i);
            Bank bank = new Bank();
            NodeList bankChild = bankdataChild.getChildNodes();
            setBank(bankChild, bank);
            banks.add(bank);
        }
    }

    public static void setBank(NodeList bankChild, Bank bank) {
        for (int j = 0; j < bankChild.getLength(); j++) {
            String bankNodeName = bankChild.item(j).getNodeName();
            String currencyType;
            double currencyAmount;
            switch (bankNodeName) {
                case "name":
                    String bankName = bankChild.item(j).getTextContent();
                    bank.setName(bankName);
                    break;
                case "address":
                    NodeList addressChilds = bankChild.item(j).getChildNodes();
                    Address address = new Address();
                    setAddress(addressChilds, address);
                    bank.setAddress(address);
                    break;
                case "dateFounded":
                    LocalDateTime dateFounded = LocalDateTime.parse(bankChild.item(j).getTextContent());
                    bank.setFoundedAt(dateFounded);
                    break;
                case "currency1":
                case "currency2":
                case "currency3":
                case "currency4":
                    currencyType = bankChild.item(j).getAttributes().getNamedItem("currencyType").getNodeValue();
                    currencyAmount = Double.parseDouble(bankChild.item(j).getTextContent());
                    setCurrency(bank, currencyAmount, currencyType);
                    break;
                case "employees":
                    NodeList employeesChild = bankChild.item(j).getChildNodes();
                    List<Employee> employees = new ArrayList<>();
                    setEmployees(employeesChild, employees);
                    bank.setEmployees(employees);
            }
        }
    }

    public static void setCurrency(Bank bank, double currencyAmount, String currencyType) {
        switch (currencyType) {
            case "USD":
                bank.setUsd(new Currency(currencyAmount, Currency.CurrencyType.USD));
                break;
            case "EUR":
                bank.setEur(new Currency(currencyAmount, Currency.CurrencyType.EUR));
                break;
            case "RUB":
                bank.setRub(new Currency(currencyAmount, Currency.CurrencyType.RUB));
                break;
            case "BYN":
                bank.setByn(new Currency(currencyAmount, Currency.CurrencyType.BYN));
                break;
        }
    }

    public static void setAddress(NodeList addressChild, Address address) {
        for (int k = 0; k < addressChild.getLength(); k++) {
            String addressNodeName = addressChild.item(k).getNodeName();
            switch (addressNodeName) {
                case "city":
                    String city = addressChild.item(k).getTextContent();
                    address.setCity(city);
                    break;
                case "street":
                    String street = addressChild.item(k).getTextContent();
                    address.setStreet(street);
                    break;
                case "houseNumber":
                    int houseNumber = Integer.parseInt(addressChild.item(k).getTextContent());
                    address.setHouseNumber(houseNumber);
                    break;
            }
        }
    }

    public static void setEmployees(NodeList employeesChild, List<Employee> employees) {
        for (int z = 0; z < employeesChild.getLength(); z++) {
            String employeesNodeName = employeesChild.item(z).getNodeName();
            if ("employee".equals(employeesNodeName)) {
                Employee employee = new Employee();
                NodeList employeeChild = employeesChild.item(z).getChildNodes();
                setEmployee(employeeChild, employee);
                employees.add(employee);
            }
        }
    }

    public static void setEmployee(NodeList employeeChild, Employee employee) {
        for (int x = 0; x < employeeChild.getLength(); x++) {
            String employeeNodeName = employeeChild.item(x).getNodeName();
            switch (employeeNodeName) {
                case "firstName":
                    String firstName = employeeChild.item(x).getTextContent();
                    employee.setFirstName(firstName);
                    break;
                case "lastName":
                    String lastName = employeeChild.item(x).getTextContent();
                    employee.setLastName(lastName);
                    break;
                case "birthday":
                    LocalDateTime birthday = LocalDateTime.parse(employeeChild.item(x).getTextContent());
                    int age = (int) ChronoUnit.YEARS.between(birthday, LocalDateTime.now());
                    employee.setBirthday(birthday);
                    employee.setAge(age);
                    break;
                case "position":
                    String position = employeeChild.item(x).getTextContent();
                    employee.setPosition(position);
                    break;
                case "currency":
                    String positionCurrencyType = employeeChild.item(x).getAttributes().getNamedItem("currencyType").getNodeValue();
                    double positionCurrencyAmount = Double.parseDouble(employeeChild.item(x).getTextContent());
                    switch (positionCurrencyType) {
                        case "USD":
                            employee.setSalary(new Currency(positionCurrencyAmount, Currency.CurrencyType.USD));
                            break;
                        case "EUR":
                            employee.setSalary(new Currency(positionCurrencyAmount, Currency.CurrencyType.EUR));
                            break;
                        case "RUB":
                            employee.setSalary(new Currency(positionCurrencyAmount, Currency.CurrencyType.RUB));
                            break;
                        case "BYN":
                            employee.setSalary(new Currency(positionCurrencyAmount, Currency.CurrencyType.BYN));
                            break;
                    }
                    break;
            }
        }
    }

}
