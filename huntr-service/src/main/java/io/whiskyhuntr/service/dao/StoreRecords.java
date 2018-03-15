package io.whiskyhuntr.service.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class StoreRecords {

    private NamedParameterJdbcTemplate jdbcTemplate;

    StoreRecords(NamedParameterJdbcTemplate aJdbcTemplate) {
        jdbcTemplate = aJdbcTemplate;
    }



}
