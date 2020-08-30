package com.ledon.test;

import com.ledon.dao.IUserDao;
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
import java.util.Date;
import java.util.List;

/**
 * mybatis入门案例
 */
public class Mybatis {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    @BeforeEach
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        sqlSession = factory.openSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @AfterEach
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    public static void main(String[] args) throws IOException {

    }

    @Test
    public void testSelect() throws IOException {
        List<USER> users = iUserDao.findAll();
        for (USER user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsert() throws IOException {
        USER user = new USER();
        user.setSex("男");
        user.setAddress("11111");
        user.setBirthday(new Date());
        user.setUsername("mybatis save");
        iUserDao.saveUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdate() throws IOException {
        USER user = new USER();
        user.setId(48);
        user.setSex("男");
        user.setAddress("11111");
        user.setBirthday(new Date());
        user.setUsername("mybatis update");
        iUserDao.updateUser(user);
    }

    @Test
    public void testDelete() throws IOException {
        iUserDao.deleteUser(42);
    }

    @Test
    public void testFindUserById() throws IOException{
        USER user = iUserDao.findById(47);
        System.out.println(user);
    }

    @Test
    public void testFindUsersLikeUsername() throws IOException{
//        List<USER> users = iUserDao.findLikeName("%王%");
        List<USER> users = iUserDao.findLikeName("王");
        for (USER user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testTotal() throws IOException{
        int total = iUserDao.total();
        System.out.println(total);
    }
}
