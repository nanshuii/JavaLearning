package com.ledon.dao;
import com.ledon.domain.USER;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 用户持久层接口
 */
@CacheNamespace(blocking = true)
public interface IUserDao {

    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "address", property = "address"),
            @Result(column = "birthday", property = "birthday"),
            @Result(property = "accounts", column = "id", many = @Many(select = "com.ledon.dao.IAccountDao.findByUid", fetchType = FetchType.LAZY))
    })
    List<USER> findAll();

    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    USER findById(Integer id);

    @Select("select * from user where username like #{username}")
    List<USER> findUsersByName(String username);

    @Select("select count(*) from user")
    int findTotal();

    @Insert("insert into user(username, address, sex, birthday) values(#{username}, #{address}, #{sex}, #{birthday})")
    void saveUser(USER user);

    @Update("update user set username = #{username}, address = #{address}, sex = #{sex}, birthday = #{birthday} where id = #{id}")
    void updateUser(USER user);

    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);


}
