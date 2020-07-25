package C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Test01 {
    public static void main(String[] args) throws SQLException {
        // 使用默认configure
        DataSource dataSource = new ComboPooledDataSource();
//        DataSource dataSource = new ComboPooledDataSource("otherName");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
