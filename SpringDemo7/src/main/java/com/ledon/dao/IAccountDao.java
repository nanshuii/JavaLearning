package com.ledon.dao;

import com.ledon.domain.Account;

public interface IAccountDao {

    Account findAccountById(Integer id);

    Account findAccountByName(String name);

    void updateAccount(Account account);

}
