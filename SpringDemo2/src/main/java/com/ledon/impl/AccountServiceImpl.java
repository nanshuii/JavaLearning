package com.ledon.impl;

import com.ledon.domain.Account;
import com.ledon.service.IAccountService;
import com.ledon.dao.IAccountDao;
import java.util.List;

/**
 * account业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    /**
     * 用来注入
     * @param accountDao
     */
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById() {
        return accountDao.findAccountById();
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
