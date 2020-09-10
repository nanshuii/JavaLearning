package com.ledon.service.impl;

import com.ledon.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountService implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行保存");
    }

    @Override
    public void updateAccount(Integer i) {
        System.out.println("执行更新" + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行删除");
        return 0;
    }
}
