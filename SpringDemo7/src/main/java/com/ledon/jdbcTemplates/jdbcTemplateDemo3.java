package com.ledon.jdbcTemplates;

import com.ledon.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * CRUD
 */
public class jdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // 保存
//        jdbcTemplate.update("insert into account(name, money) values (?, ?)", "eee", 1000);
        // 更新
//        jdbcTemplate.update("update account set name=?, money=? where id=?", "333", "333", 3);
        // 删除
//        jdbcTemplate.update("delete from account where id=?", 3);
        // 查询列表
////        List<Account> accounts = jdbcTemplate.query("select * from account where money > ?", new AccountRowMapper(), 100);
//        List<Account> accounts = jdbcTemplate.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 100);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        // 查询一个
//        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 1);
//        if (!accounts.isEmpty()) {
//            System.out.println(accounts.get(0));
//        }
        // 查询返回一行一列 使用聚合函数但不加group by
        Long count = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Long.class, 100);
        System.out.println(count);


    }


}

/**
 * 定义account的封装
 */
class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setMoney(resultSet.getFloat("money"));
        account.setName(resultSet.getString("name"));
        return account;
    }
}
