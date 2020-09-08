package com.ledon.ui;

import com.ledon.dao.IAccountDao;
import com.ledon.service.IAccountService;
import com.ledon.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        /**
         * ApplicationContext中的三个常用实现类
         * ClassPathXmlApplicationContext:可以加载类路径下的配置文件，要求配置文件必须在类路径下；
         * FileSystemXmlApplicationContext:可以加载磁盘任意路径下的配置文件，必须要有访问权限；
         * AnnotationConfigApplicationContext:读取注解创建容器
         */
        // 1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("file:///Users/ledon/Documents/programming/JavaLearning/SpringDemo1/src/main/resources/bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据id获取Bean对象
        IAccountService accountService = (IAccountService)ac.getBean("accountService");
        accountService.saveAccount();

        IAccountService accountService2 = (IAccountService)ac.getBean("accountService2");
        accountService2.saveAccount();

        IAccountService accountService3 = (IAccountService)ac.getBean("accountService3");
        accountService3.saveAccount();
    }
}
