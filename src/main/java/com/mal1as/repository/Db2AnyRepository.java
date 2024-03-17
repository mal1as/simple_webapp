package com.mal1as.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletContext;
import java.util.Map;

@Repository
public class Db2AnyRepository {

    private final String query;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Db2AnyRepository(ServletContext servletContext, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        query = servletContext.getInitParameter("sql.query");
    }

    public Map<String, Object> getAllFieldsByKey(String key) {
        return jdbcTemplate.queryForMap(query, key);
    }
}
