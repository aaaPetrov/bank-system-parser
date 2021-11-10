package com.solvd.banksystemparser;

import com.solvd.banksystemparser.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements IParse {

    public BankData parse(String pathname) {
        JAXBContext jc = null;
        Unmarshaller unmarshaller = null;
        BankData bankData = null;
        try {
            jc = JAXBContext.newInstance(BankData.class, Bank.class, Organization.class,
                    Currency.class, Employee.class, Human.class, Address.class);
            unmarshaller = jc.createUnmarshaller();
            bankData = (BankData) unmarshaller.unmarshal(new File(pathname));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return bankData;
    }

}
