/*
package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.fruit.request.FruitSaveRequest;
import com.group.libraryapp.dto.fruit.response.FruitSalesStatusResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FruitJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public FruitJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(FruitSaveRequest request) {
        String sql = "INSERT INTO fruit(name, warehousingDate, price) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public void sellFruits(Long id) {
            String sql = "UPDATE fruit SET sold = 1 WHERE id = ?";
            jdbcTemplate.update(sql, id);
    }

    public FruitSalesStatusResponse showSalesStatus(String name) {
        String salesSql = "SELECT SUM(price) FROM fruit WHERE name = ? AND sold = 1";
        String notSalesSql = "SELECT SUM(price) FROM fruit WHERE name = ? AND sold = 0";

        Integer salesAmount = jdbcTemplate.queryForObject(salesSql, Integer.class, name);
        Integer notSalesAmount = jdbcTemplate.queryForObject(notSalesSql, Integer.class, name);

        return new FruitSalesStatusResponse(salesAmount == null ? 0 : salesAmount, notSalesAmount == null ? 0 : notSalesAmount);
    }

    public boolean isNotSold(Long id) {
        String readSql = "SELECT sold FROM fruit WHERE id = ?";
        Integer soldStatus = jdbcTemplate.queryForObject(readSql, Integer.class, id);

        return soldStatus == 1;
    }
}
*/
