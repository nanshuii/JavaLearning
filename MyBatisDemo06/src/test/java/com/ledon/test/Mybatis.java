package com.ledon.test;

import com.ledon.dao.IAccountDao;
import com.ledon.dao.IUserDao;
import com.ledon.domain.Account;
import com.ledon.domain.AccountUser;
import com.ledon.domain.QueryVo;
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

    @BeforeEach
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao = sqlSession.getMapper(IAccountDao.class);
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
        List<USER> users = userDao.findAll();
        for (USER user : users) {
            System.out.println(user);
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
    public void testFindUserByCondition() throws IOException {
        USER user = new USER();
        user.setUsername("老王");
        user.setSex("男");
        List<USER> users = userDao.findUserByCondition(user);
        for (USER u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindInIds() throws IOException {
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(45);ids.add(46);ids.add(47);ids.add(48);
        queryVo.setIds(ids);
        List<USER> users = userDao.findUserInIds(queryVo);
        for (USER u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testInsert() throws IOException {
        USER user = new USER();
        user.setSex("男");
        user.setAddress("11111");
        user.setBirthday(new Date());
        user.setUsername("mybatis save");
        userDao.saveUser(user);
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
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() throws IOException {
        userDao.deleteUser(42);
    }

    @Test
    public void testFindUserById() throws IOException{
        USER user = userDao.findById(47);
        System.out.println(user);
    }

    @Test
    public void testFindUsersLikeUsername() throws IOException{
//        List<USER> users = userDao.findLikeName("%王%");
        List<USER> users = userDao.findLikeName("王");
        for (USER user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testTotal() throws IOException{
        int total = userDao.total();
        System.out.println(total);
    }

    @Test
    public void testQueryVo() throws IOException{
        QueryVo vo = new QueryVo();
        USER user = new USER();
        user.setUsername("%王%");
        vo.setUser(user);
        List<USER> users = userDao.findUserByVo(vo);
        for (USER u : users) {
            System.out.println(u);
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
    public void testAccountUserFindAll() throws IOException{
        List<AccountUser> accountUsers = accountDao.findAccountUserAll();
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);
        }
    }


    
    
}
