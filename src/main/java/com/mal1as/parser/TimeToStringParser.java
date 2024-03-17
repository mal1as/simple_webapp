package com.mal1as.parser;

import java.sql.Time;
import java.time.format.DateTimeFormatter;

public class TimeToStringParser implements ToStringParser<Time> {

    @Override
    public String parse(Object time) {
        return ((Time) time).toLocalTime().format(DateTimeFormatter.ISO_TIME);
    }
}
