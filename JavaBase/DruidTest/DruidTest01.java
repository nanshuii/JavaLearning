package DruidTest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest01 {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        Properties properties = new Properties();
        InputStream inputStream = DruidTest01.class.getClassLoader().getResourceAsStream("DruidTest/druid.properties");
        properties.load(inputStream);
        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
