package com.solvd.banksystemparser;

import com.solvd.banksystemparser.model.BankData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class.getName());

    public static void main(String[] args) {
        System.out.println("\n\n/////////////////////////////////DOM PARSER////////////////////////////\n\n");
        IParse iParser = new DomParser();
        BankData bankData1 = null;
        try {
            bankData1 = iParser.parse("./src/main/resources/bankdata.xml");
            bankData1.getBanks().forEach(bank -> {
                System.out.printf("%-60s%s%s", "\n", "BANK INNFORMATION:", "\n\n");
                System.out.println(bank);
            });
        } catch (ParserConfigurationException | IOException | SAXException e) {
            LOGGER.error(e.getMessage());
        }

        System.out.println("\n\n/////////////////////////////////JAXB PARSER////////////////////////////\n\n");
        iParser = new JaxbParser();
        BankData bankData2 = null;
        try {
            bankData2 = iParser.parse("./src/main/resources/bankdata.xml");
            bankData2.getBanks().forEach(bank -> {
                System.out.printf("%-60s%s%s", "\n", "BANK INNFORMATION:", "\n\n");
                System.out.println(bank);
            });
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n/////////////////////////////////JACKSON PARSER////////////////////////////\n\n");
        iParser = new JacksonParser();
        BankData bankData3 = null;
        try {
            bankData3 = iParser.parse("./src/main/resources/bankdata.json");
            bankData3.getBanks().forEach(bank -> {
                System.out.printf("%-60s%s%s", "\n", "BANK INNFORMATION:", "\n\n");
                System.out.println(bank);
            });
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        if (bankData1 != null && bankData1.equals(bankData2)) {
            if(bankData2.equals(bankData3)) {
                System.out.println("\n\nTHE SAME OBJECTS.");
            }
        }
    }

}