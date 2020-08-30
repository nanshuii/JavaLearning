package com.ledon.dao;

import com.ledon.domain.USER;
import org.apache.ibatis.annotations.Select;

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
     * 插入一个USER
     * @param user
     */
    void saveUser(USER user);

    /**
     * 更新USER
     * @param user
     */
    void updateUser(USER user);

    /**
     * 根据id删除USER
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据id查询USER
     * @param id
     * @return
     */
    USER findById(Integer id);

    /**
     * 根据username模糊搜索，返回USER集合
     * @param username
     * @return
     */
    List<USER> findLikeName(String username);

    /**
     * 获取总记录条数
     * @return
     */
    int total();
}
