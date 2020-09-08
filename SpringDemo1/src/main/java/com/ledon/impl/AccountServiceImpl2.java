package com.ledon.impl;

import com.ledon.service.IAccountService;

import java.util.Date;

/**
 * account业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public AccountServiceImpl2() {
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
