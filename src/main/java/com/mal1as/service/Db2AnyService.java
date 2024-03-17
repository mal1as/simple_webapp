package com.mal1as.service;

import com.google.common.collect.ImmutableMap;
import com.mal1as.parser.DateToStringParser;
import com.mal1as.parser.TimeToStringParser;
import com.mal1as.parser.TimestampToStringParser;
import com.mal1as.parser.ToStringParser;
import com.mal1as.repository.Db2AnyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class Db2AnyService {

    private static final Map<Class<?>, ToStringParser<?>> SERIALIZERS = ImmutableMap.of(
            Timestamp.class, new TimestampToStringParser(),
            Time.class, new TimeToStringParser(),
            Date.class, new DateToStringParser()
    );

    private final Db2AnyRepository db2AnyRepository;

    @Autowired
    public Db2AnyService(Db2AnyRepository db2AnyRepository) {
        this.db2AnyRepository = db2AnyRepository;
    }

    public Map<String, Object> getAnyEntityByKey(String key) {
        return db2AnyRepository.getAllFieldsByKey(key)
                .entrySet().stream().map(e -> {
                    Object value = e.getValue();
                    if(Objects.nonNull(value) && SERIALIZERS.containsKey(value.getClass())) {
                        value = SERIALIZERS.get(value.getClass()).parse(value);
                    }
                    return new AbstractMap.SimpleEntry<>(e.getKey(), value);
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
