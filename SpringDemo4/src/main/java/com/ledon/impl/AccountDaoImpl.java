package com.ledon.impl;

import com.ledon.dao.IAccountDao;
import com.ledon.domain.Account;
import com.ledon.util.ConnectionUtils;
import com.ledon.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * account持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;

    private ConnectionUtils connectionUtils;

    private TransactionManager transactionManager;

    // set注入
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public List<Account> findAllAccount() {
        return null;
    }

    @Override
    public Account findAccountById(Integer id) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer id) {

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        /**
         * try{
         *      1.开启事务
         *      2.执行操作
         *      3.提交事务
         *      4.返回结果
         * } catch (Exception e) {
         *      5.回滚
         * } finally {
         *      6.释放
         * }
         */
        try{
            transactionManager.beginTranscation();
            Account account1 = findAccountByName(sourceName);
            Account account2 = findAccountByName(targetName);
            account1.setMoney(account1.getMoney() - money);
            account2.setMoney(account2.getMoney() + money);
            updateAccount(account1);
            updateAccount(account2);
            transactionManager.commit();

        } catch (Exception e) {
            transactionManager.rollback();
            e.printStackTrace();
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public Account findAccountByName(String name) {
        return null;
    }
}
