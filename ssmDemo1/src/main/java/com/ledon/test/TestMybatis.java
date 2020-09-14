package com.ledon.test;

import com.ledon.dao.IAccountDao;
import com.ledon.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws IOException {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建sqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlSession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        // test
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        // 关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2() throws IOException{
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建sqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlSession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        // test
        Account account = new Account();
        account.setName("insert");
        account.setMoney(100.0);
        accountDao.saveAccount(account);
        session.commit();
        // 关闭资源
        session.close();
        in.close();
    }
}
