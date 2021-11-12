package com.solvd.banksystemparser.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String localDateTimeString) {
        return LocalDateTime.parse(localDateTimeString);
    }

    @Override
    public String marshal(LocalDateTime localDateTime) {
        return localDateTime.toString();
    }

}
