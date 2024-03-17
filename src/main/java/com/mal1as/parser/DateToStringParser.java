package com.mal1as.parser;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class DateToStringParser implements ToStringParser<Date> {

    @Override
    public String parse(Object date) {
        return ((Date) date).toLocalDate().format(DateTimeFormatter.ISO_DATE);
    }
}
