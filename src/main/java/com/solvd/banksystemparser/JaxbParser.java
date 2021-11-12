package com.solvd.banksystemparser;

import com.solvd.banksystemparser.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements IParse {

    @Override
    public BankData parse(String pathname) {
        JAXBContext jc;
        Unmarshaller unmarshaller;
        try {
            jc = JAXBContext.newInstance(BankData.class, Bank.class, Organization.class,
                    Currency.class, Employee.class, Human.class, Address.class);
            unmarshaller = jc.createUnmarshaller();
            return  (BankData) unmarshaller.unmarshal(new File(pathname));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
