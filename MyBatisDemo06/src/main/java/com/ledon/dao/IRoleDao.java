package com.ledon.dao;

import com.ledon.domain.Role;

import java.util.List;

public interface IRoleDao {

    /**
     * 查询所有Role
     * @return
     */
    List<Role> findAll();

}
