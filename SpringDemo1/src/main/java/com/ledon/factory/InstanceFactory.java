package com.ledon.factory;

import com.ledon.impl.AccountServiceImpl;
import com.ledon.service.IAccountService;

public class InstanceFactory {
    public IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
