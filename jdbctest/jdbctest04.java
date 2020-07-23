package jdbctest;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbctest04 {

    public static void main(String[] args) {
        List<Test02Object> list = new jdbctest04().findAll();
        System.out.println(list);
    }

    public List<Test02Object> findAll() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from test02";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Test02Object object = null;
        List<Test02Object> list = new ArrayList<Test02Object>();
        try {
            while (resultSet.next()) {
                String address = resultSet.getString("address");
                int age = resultSet.getInt("age");
                int endlish = resultSet.getInt("endlish");
                int id = resultSet.getInt("id");
                int math = resultSet.getInt("math");
                String name = resultSet.getString("name");
                int sex = resultSet.getInt("sex");
                object = new Test02Object();
                object.setAge(age);
                object.setEndlish(endlish);
                object.setId(id);
                object.setMath(math);
                object.setName(name);
                list.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(resultSet, statement, connection);
        return list;
    }
}
