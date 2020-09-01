package com.ledon.dao;
import com.ledon.domain.USER;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有USER
     * @return List<USER>
     */
    List<USER> findAll();

    /**
     * 查询所有USER延迟加载Account
     * @return
     */
    List<USER> findAllDelay();

    /**
     * 查询所有USER和关联的role
     * @return
     */
    List<USER> findUsersRoles();

    /**
     * 根据id查询USER
     * @param id
     * @return
     */
    USER findById(Integer id);
}
