package com.dao.service;

import com.dao.BaseDao;
import com.entity.USER;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    /**
     * 插入一条用户信息
     * @param user
     * @return
     */
    public static int insert(USER user) {
        String sql = "insert into USER values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";
        Object[] params = new Object[]{
                user.getUSER_ID(),
                user.getUSER_NAME(),
                user.getUSER_PASSWORD(),
                user.getUSER_SEX(),
                user.getUSER_BIRTHDAY(),
                user.getUSER_IDENITY_CODE(),
                user.getUSER_EMAIL(),
                user.getUSER_MOBILE(),
                user.getUSER_ADDRESS(),
                user.getUSER_STATUS()};
        return BaseDao.executeIUD(sql, params);
    }

    /**
     * 返回所有用户数据
     * @param keywords 用户名搜索
     * @return USERS列表
     */
    public static ArrayList<USER> selectAll(String keywords) {
        String sql = "select * from USER order by USER_ID";
        if (keywords != null) {
            sql = "select *from USER where USER_NAME like ? order by USER_ID";
        }
        return select(sql, -1, -1, keywords);
    }

    /**
     * 分页返回用户数据
     * @param currentPage 当前页
     * @param count 每页数量
     * @param keywords 用户名搜索
     * @return USERS列表
     */
    public static ArrayList<USER> selectPage(int currentPage, int count, String keywords) {
        String sql = "select * from USER order by USER_ID limit ?, ?";
        if (keywords != null) {
            sql = "select * from USER where USER_NAME like ? order by USER_ID limit ?, ?";
        }
        return select(sql, currentPage, count, keywords);
    }

    /**
     * 返回用户数据
     * @param sql sql
     * @param currentPage 当前页；-1代表不分页
     * @param count 每页数量; -1代表不分页
     * @param key2ords 用户名搜索
     * @return USERS列表
     */
    private static ArrayList<USER> select(String sql, int currentPage, int count, String keywords) {
        ArrayList<USER> users = new ArrayList<USER>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = BaseDao.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (keywords != null) {
                if (currentPage != -1 && count != -1) {
                    // 说明是分页
                    preparedStatement.setString(1, "%" + keywords + "%");
                    preparedStatement.setInt(2, (currentPage-1)*count);
                    preparedStatement.setInt(3, count);
                } else {
                    preparedStatement.setString(1, "%" + keywords + "%");
                }
            } else {
                if (currentPage != -1 && count != -1) {
                    // 说明是分页
                    preparedStatement.setInt(1, (currentPage-1)*count);
                    preparedStatement.setInt(2, count);
                }
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                USER user = getUSERFromResult(resultSet);
                if (user != null) {
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return users;
    }

    /**
     * 从ResultSet中获取USER
     * @param resultSet resultSet
     * @return USER
     */
    private static USER getUSERFromResult(ResultSet resultSet) {
        USER user = null;
        try {
            user = new USER(
                    resultSet.getString("USER_ID"),
                    resultSet.getString("USER_NAME"),
                    resultSet.getString("USER_PASSWORD"),
                    resultSet.getString("USER_SEX"),
                    resultSet.getString("USER_BIRTHDAY"),
                    resultSet.getString("USER_EMAIL"),
                    resultSet.getString("USER_IDENITY_CODE"),
                    resultSet.getString("USER_MOBILE"),
                    resultSet.getString("USER_ADDRESS"),
                    resultSet.getInt("USER_STATUS")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 获取总记录数和总页数
     * @param count 每页数量
     * @param keywords 用户名搜索
     * @return int数组，0总记录数，1总页数
     */
    public static int[] totalPage(int count, String keywords) {
        int arr[] = {0, 1};
        String sql = "select count(*) from USER";
        if (keywords != null) {
            sql = "select count(*) from USER where USER_NAME like ?";
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = BaseDao.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (keywords != null) {
                preparedStatement.setString(1, "%" + keywords + "%");
            }

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arr[0] = resultSet.getInt(1);
                if (arr[0] % count == 0) {
                    arr[1] = arr[0]/count;
                } else {
                    arr[1] = arr[0]/count + 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return arr;
    }

    /**
     * 通过userId来查找User
     * @param userId userId
     * @return USER
     */
    public static USER selectById(String userId) {
        String sql = "select u.*, DATE_FORMAT(u.USER_BIRTHDAY, '%Y-%m-%d')birthday from USER u where USER_ID = ?";
        USER user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = BaseDao.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = getUSERFromResult(resultSet);
                user.setUSER_BIRTHDAY(resultSet.getString("birthday")); // 对birthday进行日期格式化

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return user;
    }

    /**
     * 查找具有相同USER_ID的对象的数量
     * @param username USER_ID
     * @return 数量
     */
    public static int selectByUsername(String username) {
        int count = 0;
        String sql = "select count(*) from USER where USER_ID = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = BaseDao.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return count;
    }

    /**
     * 通过USER_ID和USER_PASSWORD查询用户
     * @param username USER_ID
     * @param password USER_PASSWORD
     * @return 用户数组
     */
    public static ArrayList<USER> selectByUsernameAndPassword(String username, String password) {
        ArrayList<USER> users = new ArrayList<USER>();
        String sql = "select * from USER where USER_ID = ? and USER_PASSWORD = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = BaseDao.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                USER user = getUSERFromResult(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return users;
    }

    /**
     * 通过USER_ID和USER_PASSWORD查询admin用户
     * @param username USER_ID
     * @param password USER_PASSWORD
     * @return 用户数组
     */
    public static ArrayList<USER> selectAdminByUsernameAndPassword(String username, String password) {
        ArrayList<USER> users = new ArrayList<USER>();
        String sql = "select * from USER where USER_ID = ? and USER_PASSWORD = ? and USER_STATUS = 2";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = BaseDao.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                USER user = getUSERFromResult(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return users;
    }

    /**
     * 更新用户信息
     * @param user USER
     * @return 大于0表示成功
     */
    public static int updateUser(USER user) {
        String sql = "update USER set USER_NAME = ?, " +
                "USER_PASSWORD = ?, " +
                "USER_SEX = ?, " +
                "USER_BIRTHDAY = DATE_FORMAT(?, '%y-%m-%d'), " +
                "USER_IDENITY_CODE = ?, " +
                "USER_EMAIL = ?, " +
                "USER_MOBILE = ?, " +
                "USER_ADDRESS = ?," +
                "USER_STATUS = ? " +
                "where USER_ID = ?";
        Object[] params = new Object[]{
                user.getUSER_NAME(),
                user.getUSER_PASSWORD(),
                user.getUSER_SEX(),
                user.getUSER_BIRTHDAY(),
                user.getUSER_IDENITY_CODE(),
                user.getUSER_EMAIL(),
                user.getUSER_MOBILE(),
                user.getUSER_ADDRESS(),
                user.getUSER_STATUS(),
                user.getUSER_ID()};
        return BaseDao.executeIUD(sql, params);
    }

    /**
     * 删除一个用户信息
     * @param userId userId
     * @return 大于0表示成功
     */
    public static int deleteUserById(String userId) {
        String sql = "delete from USER where USER_ID = ? and USER_STATUS = 1";
        int count = BaseDao.executeIUD(sql, new Object[]{userId});
        return count;
    }

    /**
     * 批量删除用户信息
     * @param userIds userId数组
     * @return 大于0表示成功
     */
    public static int deleteUsersByIds(List<String> userIds) {
        String sql = "delete from USER where USER_ID in ? and USER_STATUS = 1";
        int count = BaseDao.executeIUD(sql, new Object[]{userIds});
        return count;
    }
}
