package com.ledon.dao;

import com.ledon.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 延迟加载
     * @return
     */
    List<Account> findAllDelay();

    /**
     * 通过uid查询所有账户
     * @param uid
     * @return
     */
    List<Account> findByUid(Integer uid);
}
