package com.ledon.service;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    void saveAccount();

    void updateAccount(Integer i);

    int deleteAccount();
}
