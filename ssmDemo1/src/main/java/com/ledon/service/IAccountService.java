package com.ledon.service;

import com.ledon.domain.Account;

import java.util.List;

public interface IAccountService {

    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存Account
     * @param account
     */
    public void saveAccount(Account account);
}
