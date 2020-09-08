package com.ledon.ui;

import com.ledon.dao.IAccountDao;
import com.ledon.service.IAccountService;
import com.ledon.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService)ac.getBean("accountService");
        System.out.println(accountService);
//        accountService.saveAccount();
//        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
//        System.out.println(accountDao);
        IAccountService accountService2 = (IAccountService)ac.getBean("accountService");
        System.out.println(accountService2);

        System.out.println(accountService == accountService2);
    }
}
