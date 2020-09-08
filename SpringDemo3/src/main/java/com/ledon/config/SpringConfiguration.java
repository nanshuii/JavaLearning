package com.ledon.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 配置类；与bean.xml相同
 * Configuration
 *  指定当前类是配置类
 * ComponentScan
 *  用于通过注解指定spring在创建容器时要扫描的包
 *  此注解等同于在xml配置<context:component-scan base-package="org.example"/>
 * Bean
 *  用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *  name：指定bean的id；默认是当前方法的名称
 *  当使用注解配置方法时如果方法有参数，spring会去查找容器中是否有可用的bean对象
 * Import
 *  用于导入其他的配置类
 *  value：用于指定其他配置类的字节码
 *  使用Import注解之后，有Import注解的类就是父配置类，Import导入的是子配置类
 * PropertySource
 *  用于指定properties文件的位置
 *  classpath表示类路径
 */
@Configuration
@ComponentScan("com.ledon")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Value("${jdbc.jdbcUrl")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 用于创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl(jdbcUrl);
        ds.setUser(user);
        ds.setPassword(password);
        return ds;
    }
}
