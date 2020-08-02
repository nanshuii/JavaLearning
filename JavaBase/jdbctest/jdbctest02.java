package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbctest02 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into test02 values(7,777,3,3,4,6,7)";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest01?useSSL=false", "root", "12345678");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count == 0) {
                System.out.println("添加失败");
            } else {
                System.out.println("添加成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            statement.close();
//            connection.close();
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
