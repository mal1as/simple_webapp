package com.mal1as.service;

import com.mal1as.repository.Db2AnyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Db2AnyService {

    @Autowired
    private Db2AnyRepository db2AnyRepository;

    public Map<String, Object> getAnyEntityByKey(String key) {
        return db2AnyRepository.getAllFieldsByKey(key);
    }
}
