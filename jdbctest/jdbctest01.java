package jdbctest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbctest01 {
    public static void main(String[] args) throws Exception{
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest01?useSSL=false", "root", "12345678");
        // 定义sql语句
        String sql = "UPDATE `dbtest01`.`test02` SET `age` = '2'";
        // 获取执行sql的对象
        Statement statement = conn.createStatement();
        // 执行sql
        int count = statement.executeUpdate(sql);
        // 处理结果
        System.out.println(count);
        // 释放资源
        statement.close();
        conn.close();
    }
}
