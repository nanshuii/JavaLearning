package com.ledon.test;

import com.ledon.dao.IAccountDao;
import com.ledon.dao.IRoleDao;
import com.ledon.dao.IUserDao;
import com.ledon.domain.Account;
import com.ledon.domain.Role;
import com.ledon.domain.USER;
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
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao accountDao;
    private IRoleDao roleDao;

    @BeforeEach
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
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
        }
    }

    @Test
    public void testSelectDelay() throws IOException {
        List<USER> users = userDao.findAllDelay();
        for (USER user : users) {
//            System.out.println(user);
        }
    }

    @Test
    public void testSelectRoles() throws IOException {
        List<USER> users = userDao.findUsersRoles();
        for (USER user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testAccountFindAll() throws IOException{
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testAccountAllDelay() throws IOException {
        List<Account> accounts = accountDao.findAllDelay();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testRoleSelect() throws IOException{
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
        }
    }
}
