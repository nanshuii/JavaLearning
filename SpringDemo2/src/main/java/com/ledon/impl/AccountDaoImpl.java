package com.ledon.impl;

import com.ledon.dao.IAccountDao;
import com.ledon.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * account持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;

    // set注入
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {
        return null;
    }

    @Override
    public Account findAccountById() {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer id) {

    }
}
