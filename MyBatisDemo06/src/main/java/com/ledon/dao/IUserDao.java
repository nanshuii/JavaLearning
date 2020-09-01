package com.ledon.dao;

import com.ledon.domain.QueryVo;
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
     * 通过queryVo中的条件查询用户
     * @param vo
     * @return List<USER>
     */
    List<USER> findUserByVo(QueryVo vo);


    /**
     * 根据传入的参数条件查询
     * @param USER user
     * @return
     */
    List<USER> findUserByCondition(USER user);

    /**
     * 根据QueryVo中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<USER> findUserInIds(QueryVo vo);



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
     * 用户数量
     */
    int total();

    List<USER> findUsersRoles();
}
