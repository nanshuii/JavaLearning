package com.ledon.impl;

import com.ledon.dao.IAccountDao;

/**
 * account持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("account save success");
    }
}
