package com.ledon.dao;

import com.ledon.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {

    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user", column = "uid", one = @One(select = "com.ledon.dao.IUserDao.findById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid = #{uid}")
    List<Account> findByUid(Integer uid);

}
