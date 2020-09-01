package com.ledon.domain;

import java.util.List;

public class QueryVo {
    private USER user;
    private List<Integer> ids;

    public USER getUser() {
        return user;
    }

    public void setUser(USER user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
