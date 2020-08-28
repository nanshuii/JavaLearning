package com.ledon.dao;

import com.ledon.domain.USER;
import com.ledon.mybatis.annotations.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有USER
     * @return List<USER>
     */
    @Select("select * from USER")
    List<USER> findAll();
}
