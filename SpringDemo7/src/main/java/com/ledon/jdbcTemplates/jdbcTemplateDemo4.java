package com.ledon.jdbcTemplates;

import com.ledon.dao.IAccountDao;
import com.ledon.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTemplateDemo4 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        Account account1 = accountDao.findAccountById(1);
        System.out.println(account1);
        Account account2 = accountDao.findAccountByName("2222");
        System.out.println(account2);
        account2.setMoney(1999f);
        accountDao.updateAccount(account2);

    }
}
