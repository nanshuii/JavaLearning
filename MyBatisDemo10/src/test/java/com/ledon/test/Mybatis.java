package com.ledon.test;

import com.ledon.dao.IAccountDao;
import com.ledon.dao.IRoleDao;
import com.ledon.dao.IUserDao;
import com.ledon.domain.Account;
import com.ledon.domain.Role;
import com.ledon.domain.USER;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * mybatis入门案例
 */
public class Mybatis {

    private InputStream inputStream;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao accountDao;
    private IRoleDao roleDao;

    @BeforeEach
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao = sqlSession.getMapper(IAccountDao.class);
        roleDao = sqlSession.getMapper(IRoleDao.class);
    }

    @AfterEach
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testSelect() throws IOException {
        List<USER> users = userDao.findAll();
        for (USER user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testFindById() throws IOException{
        USER user1 = userDao.findById(47);
        System.out.println(user1);
        USER user2 = userDao.findById(47);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

    @Test
    public void testFindUsersByUsername() throws IOException{
        List<USER> users = userDao.findUsersByName("%mybatis%");
        for (USER u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testUsersTotal() throws IOException{
        Integer count = userDao.findTotal();
        System.out.println(count);
    }

    @Test
    public void testInsert() throws IOException{
        USER user = new USER();
        user.setUsername("insert");
        user.setSex("女");
        user.setAddress("address很好");
        user.setBirthday(new Date());
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() throws IOException{
        USER user = new USER();
        user.setId(50);
        user.setUsername("update");
        user.setSex("男");
        user.setAddress("address");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() throws IOException{
        userDao.deleteUser(50);
    }

    @Test
    public void testAccountAll() throws IOException{
        List<Account> accounts = accountDao.findAll();
        for (Account account: accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
