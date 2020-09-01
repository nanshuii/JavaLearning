package com.ledon.dao;

import com.ledon.domain.Account;
import com.ledon.domain.AccountUser;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且查询到该账户对应用户
     * @return
     */
    List<AccountUser> findAccountUserAll();
}
