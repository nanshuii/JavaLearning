package com.ledon.service;

import com.ledon.domain.Account;

import java.util.List;

/**
 * account业务层接口
 */
public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 通过id查询Account
     * @return
     */
    Account findAccountById();

    /**
     * 更新account
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 通过id删除Account
     * @param id
     */
    void deleteAccount(Integer id);
}
