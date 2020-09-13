package com.ledon.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ParamsTest implements Serializable {
    private String username;
    private String password;
    private Double money;
    private ParamsTestUser user;
    private List<ParamsTestUser> list;
    private Map<String, ParamsTestUser> map;

    public List<ParamsTestUser> getList() {
        return list;
    }

    public void setList(List<ParamsTestUser> list) {
        this.list = list;
    }

    public Map<String, ParamsTestUser> getMap() {
        return map;
    }

    public void setMap(Map<String, ParamsTestUser> map) {
        this.map = map;
    }

    public ParamsTestUser getUser() {
        return user;
    }

    public void setUser(ParamsTestUser user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "ParamsTest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
