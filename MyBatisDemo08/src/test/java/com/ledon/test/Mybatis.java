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
        }
    }

    @Test
    public void testFirstLevelCache() throws IOException {
        USER user1 = userDao.findById(41);
        System.out.println(user1);
        sqlSession.clearCache();
        USER user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

    @Test
    public void testClearCache() throws IOException {
        USER user1 = userDao.findById(41);
        System.out.println(user1);
        // 更新用户信息
        user1.setUsername("update_cache222");
        userDao.updateUser(user1);
        // 再获取
        USER user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }

    @Test
    public void testTwoCache() throws IOException{
        SqlSession sqlSession1 = factory.openSession();
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        USER user1 = userDao1.findById(41);
        System.out.println(user1);
        sqlSession1.close();

        SqlSession sqlSession2 = factory.openSession();
        IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
        USER user2 = userDao2.findById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1 == user2);
    }

}
