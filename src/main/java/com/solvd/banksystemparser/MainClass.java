package com.solvd.banksystemparser;

import com.solvd.banksystemparser.model.Bank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class.getName());

    public static void main(String[] args) {
        IParse iParser = new DomParser();
        List<Bank> banks = null;
        try {
            banks = iParser.parse("./src/main/resources/bankdata.xml");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            LOGGER.error(e.getMessage());
        }
        banks.forEach(bank -> {
            System.out.printf("%-60s%s%s", "\n", "BANK INNFORMATION:", "\n\n");
            System.out.println(bank);
        });
    }

}