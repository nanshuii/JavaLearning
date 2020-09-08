package com.ledon.impl;

import com.ledon.service.IAccountService;
import com.ledon.dao.IAccountDao;

import java.util.Date;

/**
 * account业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl 创建");
    }

    public void saveAccount() {
        System.out.println("AccountServiceImpl saveAccount ..." + name + " " + age + " " + birthday);
    }

    public void init() {
        System.out.println("对象init");
    }

    public void destroy() {
        System.out.println("对象destroy");
    }
}
