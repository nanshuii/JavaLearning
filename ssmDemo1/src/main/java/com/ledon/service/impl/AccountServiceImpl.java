package com.ledon.service.impl;

import com.ledon.dao.IAccountDao;
import com.ledon.domain.Account;
import com.ledon.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    private final IAccountDao accountDao;

    public AccountServiceImpl(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        System.out.println("service findAll");
        return accountDao.findAll();
//        return null;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("service saveAccount");
        accountDao.saveAccount(account);
    }
}
