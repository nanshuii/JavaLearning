package com.ledon.test;

import com.ledon.domain.Account;
import com.ledon.service.IAccountService;
import com.ledon.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = ac.getBean("accountService", AccountServiceImpl.class);
        accountService.findAll();
        accountService.saveAccount(new Account());
    }
}
