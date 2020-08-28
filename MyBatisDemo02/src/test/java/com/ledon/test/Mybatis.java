package com.ledon.test;

import com.ledon.dao.IUserDao;
import com.ledon.domain.USER;
import com.ledon.mybatis.io.Resources;
import com.ledon.mybatis.sqlsession.SqlSession;
import com.ledon.mybatis.sqlsession.SqlSessionFactory;
import com.ledon.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis入门案例
 */
public class Mybatis {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // 1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建一个SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        // 3.使用工厂生产一个SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 5.使用代理对象执行方法
        List<USER> users = userDao.findAll();
        for (USER user : users) {
            System.out.println(user);
        }
        // 6.释放资源
        sqlSession.close();
        inputStream.close();
    }
}
