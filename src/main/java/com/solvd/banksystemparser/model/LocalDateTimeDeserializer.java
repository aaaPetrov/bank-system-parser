package com.solvd.banksystemparser.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {


    public LocalDateTimeDeserializer() {
        this(null);
    }

    public LocalDateTimeDeserializer(Class<LocalDateTime> localDateTime) {
        super(localDateTime);
    }

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) {
        try {
            String dateTimeString = parser.getText();
            LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString);
            return localDateTime;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
