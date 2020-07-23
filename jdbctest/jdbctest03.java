package jdbctest;

import java.sql.*;

public class jdbctest03 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select * from test02";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest01?useSSL=false", "root", "12345678");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            // 获取第一行的数据 默认在0行
//            resultSet.next();
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString("name");
//            System.out.println("id = " + id + " name = " + name);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                System.out.println("id = " + id + " name = " + name);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
