package com.ledon.dao;

import com.ledon.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 账户dao接口
 */
public interface IAccountDao {

    /**
     * 查询所有账户
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 保存Account
     * @param account
     */
    @Insert("insert into account (name, money) values(#{name}, #{money})")
    public void saveAccount(Account account);
}
