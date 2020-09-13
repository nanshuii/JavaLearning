package com.ledon.domain;

import java.io.Serializable;
import java.util.Date;

public class ParamsTestUser implements Serializable {
    private String name;
    private String pwd;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ParamsTestUser{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", date=" + date +
                '}';
    }
}
