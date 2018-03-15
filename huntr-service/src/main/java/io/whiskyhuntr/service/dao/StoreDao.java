package io.whiskyhuntr.service.dao;

import io.whiskyhuntr.service.dao.model.StoreRowMapper;
import io.whiskyhuntr.service.resources.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class StoreDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Store getStoreById(int storeId){
        String sql = "SELECT * FROM store WHERE id = :store_id";

        Map<String, Object> params = new HashMap<>();
        params.put("store_id", storeId);

        List<Store> store = jdbcTemplate.query(
                sql, params, new StoreRowMapper());

        return store.get(0);
    }

}
