package com.ledon.impl;

import com.ledon.service.IAccountService;

import java.util.*;

/**
 * account业务层实现类
 */
public class AccountServiceImpl3 implements IAccountService {

    private String[] strings;
    private List<String> list;
    private Set<String> set;
    private Map<String, String > map;
    private Properties properties;

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(strings));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(properties);
    }
}
