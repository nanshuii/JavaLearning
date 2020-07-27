package JDBCTemplateTest;

import jdbctest.JDBCUtils;
import jdbctest.Test02Object;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplateTest01 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//        String sql = "update test02 set name = 'jdbctemplatetest' where id = ?";
//        // 设置sql，以及设置每一个问号对应的值
//        int count = template.update(sql, 2);
//        System.out.println(count);
//
//        // 添加一条记录
//        String sql1 = "insert into test02(id, name, age) values(?, ?, ?)";
//        int count1 = template.update(sql1, 8, "888", 8);
//        System.out.println(count1);

//        // 删除一条记录
//        String sql2 = "delete from test02 where id = ?";
//        int count2 = template.update(sql2, 8);
//        System.out.println(count2);

//        // map查询一个用户操作
//        String sql3 = "select * from test02 where id = 1";
//        Map<String, Object> map = template.queryForMap(sql3);
//        System.out.println(map);
//
//        // list查询所有记录
//        String sql4 = "select * from test02";
//        List<Map<String, Object>> list = template.queryForList(sql4);
//        for (Map<String, Object> stringObjectMap : list) {
//            System.out.println(stringObjectMap);
//        }

//        // object查询所有记录,JavaBean
//        String sql5 = "select * from test02";
//        List<Test02Object> list = template.query(sql5, new BeanPropertyRowMapper<Test02Object>(Test02Object.class));
//        for (Test02Object test02Object : list) {
//            System.out.println(test02Object.toString());
//        }


        // 查询记录数
        String sql6 = "select count(id) from test02";
        Long total = template.queryForObject(sql6, Long.class);
        System.out.println(total);


    }
}
