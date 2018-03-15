package io.whiskyhuntr.service.dao.model;

import io.whiskyhuntr.service.resources.Store;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Store store = new Store();
        store.setId(rs.getInt("id"));
        store.setBaseUrl(rs.getString("base_url"));
        store.setName(rs.getString("name"));
        store.setSearchUrl(rs.getString("search_url"));
        return store;
    }
}
