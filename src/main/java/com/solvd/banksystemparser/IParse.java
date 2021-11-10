package com.solvd.banksystemparser;

import com.solvd.banksystemparser.model.BankData;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface IParse {

    BankData parse(String pathname) throws ParserConfigurationException, IOException, SAXException;

}
