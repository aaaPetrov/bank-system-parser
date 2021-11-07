package com.solvd.banksystemparser;

import com.solvd.banksystemparser.currency.Currency;
import com.solvd.banksystemparser.employee.Employee;
import com.solvd.banksystemparser.organization.address.Address;
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

public class MainClass implements IParse {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        MainClass mainClass = new MainClass();
        List<Bank> banks = mainClass.parse("./src/main/resources/bankdata.xml");
        banks.forEach(bank -> bank.print());
    }

    @Override
    public List<Bank> parse(String pathname) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(pathname));
        NodeList bankElements = document.getDocumentElement().getElementsByTagName("bank");
        List<Bank> banks = new ArrayList<>();
        for (int i = 0; i < bankElements.getLength(); i++) {
            Node bankElement = bankElements.item(i);
            Bank bank = new Bank();
            if (bankElement.hasChildNodes()) {
                NodeList bankChilds = bankElement.getChildNodes();
                for (int j = 0; j < bankChilds.getLength(); j++) {
                    String bankNodeName = bankChilds.item(j).getNodeName();
                    switch (bankNodeName) {
                        case "name":
                            String bankName = bankChilds.item(j).getTextContent();
                            bank.setName(bankName);
                            break;
                        case "address":
                            NodeList addressChilds = bankChilds.item(j).getChildNodes();
                            Address address = new Address();
                            for (int k = 0; k < addressChilds.getLength(); k++) {
                                String addressNodeName = addressChilds.item(k).getNodeName();
                                switch (addressNodeName) {
                                    case "city":
                                        String city = addressChilds.item(k).getTextContent();
                                        address.setCity(city);
                                        break;
                                    case "street":
                                        String street = addressChilds.item(k).getTextContent();
                                        address.setStreet(street);
                                        break;
                                    case "houseNumber":
                                        int houseNumber = Integer.parseInt(addressChilds.item(k).getTextContent());
                                        address.setHouseNumber(houseNumber);
                                        break;
                                }
                            }
                            bank.setAddress(address);
                            break;
                        case "dateFounded":
                            LocalDateTime dateFounded = LocalDateTime.parse(bankChilds.item(j).getTextContent());
                            bank.setFoundedAt(dateFounded);
                            break;
                        case "currency":
                            String currencyType = bankChilds.item(j).getAttributes().getNamedItem("currencyType").getNodeValue();
                            double currencyAmount = Double.parseDouble(bankChilds.item(j).getTextContent());
                            switch (currencyType) {
                                case "USD":
                                    bank.setUsd(new Currency(currencyAmount, Currency.CurrencyType.USD));
                                    break;
                                case "EUR":
                                    bank.setEur(new Currency(currencyAmount, Currency.CurrencyType.EURO));
                                    break;
                                case "RUB":
                                    bank.setRub(new Currency(currencyAmount, Currency.CurrencyType.RUB));
                                    break;
                                case "BYN":
                                    bank.setByn(new Currency(currencyAmount, Currency.CurrencyType.BYN));
                                    break;
                            }
                            break;
                        case "employees" :
                            NodeList employeesChilds = bankChilds.item(j).getChildNodes();
                            List<Employee> employees = new ArrayList<>();
                            for (int z = 0; z < employeesChilds.getLength(); z++) {
                                String employeesNodeName = employeesChilds.item(z).getNodeName();
                                if("employee".equals(employeesNodeName)) {
                                    Employee employee = new Employee();
                                    NodeList employeeChilds = employeesChilds.item(z).getChildNodes();
                                    for (int x = 0; x < employeeChilds.getLength(); x++) {
                                        String employeeNodeName = employeeChilds.item(x).getNodeName();
                                        switch (employeeNodeName) {
                                            case "firstName":
                                                String firstName = employeeChilds.item(x).getTextContent();
                                                employee.setFirstName(firstName);
                                                break;
                                            case "lastName":
                                                String lastName = employeeChilds.item(x).getTextContent();
                                                employee.setLastName(lastName);
                                                break;
                                            case "birthday":
                                                LocalDateTime birthday = LocalDateTime.parse(employeeChilds.item(x).getTextContent());
                                                int age = (int) ChronoUnit.YEARS.between(birthday, LocalDateTime.now());
                                                employee.setBirthday(birthday);
                                                employee.setAge(age);
                                                break;
                                            case "position":
                                                String position = employeeChilds.item(x).getTextContent();
                                                employee.setPosition(position);
                                                break;
                                            case "currency":
                                                String positionCurrencyType = employeeChilds.item(x).getAttributes().getNamedItem("currencyType").getNodeValue();
                                                double positionCurrencyAmount = Double.parseDouble(employeeChilds.item(x).getTextContent());
                                                switch (positionCurrencyType) {
                                                    case "USD":
                                                        employee.setSalary(new Currency(positionCurrencyAmount, Currency.CurrencyType.USD));
                                                        break;
                                                    case "EUR":
                                                        employee.setSalary(new Currency(positionCurrencyAmount, Currency.CurrencyType.EURO));
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
                                    employees.add(employee);
                                }
                            }
                            bank.setEmployees(employees);
                    }
                }
            }
            banks.add(bank);
        }
        return banks;
    }

}