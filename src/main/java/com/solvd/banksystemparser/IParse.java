package com.solvd.banksystemparser;

import com.solvd.banksystemparser.model.Bank;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface IParse {

    List<Bank> parse(String pathname) throws ParserConfigurationException, IOException, SAXException;

}
