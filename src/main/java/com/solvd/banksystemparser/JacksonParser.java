package com.solvd.banksystemparser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.banksystemparser.model.BankData;
import java.io.File;
import java.io.IOException;

public class JacksonParser implements IParse {

    @Override
    public BankData parse(String pathname) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(pathname), BankData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
