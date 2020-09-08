package com.ledon.factory;

import com.ledon.impl.AccountServiceImpl;
import com.ledon.service.IAccountService;

public class StaticFactory {
    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
