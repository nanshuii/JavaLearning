package com.ledon.jdbcTemplates;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate最基本用法
 */
public class jdbcTemplateDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springDemo");
        ds.setUsername("root");
        ds.setPassword("12345678");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        jdbcTemplate.execute("insert into account (name, money) values ('ccc', 1000)");

    }
}
