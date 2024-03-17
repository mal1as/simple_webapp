package com.mal1as.parser;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class TimestampToStringParser implements ToStringParser<Timestamp> {

    @Override
    public String parse(Object timestamp) {
        return ((Timestamp) timestamp).toLocalDateTime().format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
