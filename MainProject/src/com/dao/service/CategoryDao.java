package com.dao.service;

import com.dao.BaseDao;
import com.entity.CATEGORY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDao {

    /**
     * 获取所有的category
     * @return ArrayList<CATEGORY>
     */
    public static ArrayList<CATEGORY> selectAll() {
        String sql = "select * from CATEGORY";
        ArrayList<CATEGORY> categories = new ArrayList<CATEGORY>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = BaseDao.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CATEGORY category = getCategoryByResultSet(resultSet);
                if (category != null) {
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return categories;
    }

    /**
     * 获取一级二级分类
     * @param parent 0 一级分类；-1 二级分类；其他 改父分类下的子分类
     * @return CATEGORY数组
     */
    public static ArrayList<CATEGORY> selectAll(int parent) {
        ArrayList<CATEGORY> categories = new ArrayList<CATEGORY>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = null;
        connection = BaseDao.getConnection();
        try {
            if (parent == 0) {
                // 获取所有的一级分类
                sql = "select * from CATEGORY where CATE_PARENT_ID = 0 order by CATE_ID ASC";
                preparedStatement = connection.prepareStatement(sql);
            } else if (parent == -1) {
                // 获取所有的二级分类
                sql = "select * from CATEGORY where CATE_PARENT_ID != 0";
                preparedStatement = connection.prepareStatement(sql);
            } else {
                sql = "select * from CATEGORY where CATE_PARENT_ID = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, parent);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CATEGORY category = getCategoryByResultSet(resultSet);
                if (category != null) {
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return categories;
    }

    /**
     * 通过ResultSet获取CATEGORY
     * @param resultSet resultSet
     * @return CATEGORY
     */
    private static CATEGORY getCategoryByResultSet(ResultSet resultSet) {
        CATEGORY category = null;
        try {
            category = new CATEGORY(
                    resultSet.getInt("CATE_ID"),
                    resultSet.getString("CATE_NAME"),
                    resultSet.getInt("CATE_PARENT_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    /**
     * 数据库插入一个CATEGORY
     * @param category
     * @return 大于0表示成功
     */
    public static int categoryAdd(CATEGORY category) {
        String sql = "insert into CATEGORY values(null, ?, ?)";
        Object[] params = new Object[]{
                category.getCATE_NAME(),
                category.getCATE_PARENT_ID()
        };
        return BaseDao.executeIUD(sql, params);
    }

    /**
     * 通过id查询Category
     * @param id id
     * @return CATEGORY
     */
    public static CATEGORY selectCategoryById(int id) {
        CATEGORY category = null;
        String sql = "select * from CATEGORY where CATE_ID = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = BaseDao.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category = getCategoryByResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    /**
     * 更新Category
     * @param category category
     * @return 大于0表示成功
     */
    public static int updateCategory(CATEGORY category) {
        String sql = "update CATEGORY set CATE_NAME = ?, CATE_PARENT_ID = ? where CATE_ID = ?";
        return BaseDao.executeIUD(sql, new Object[]{
                category.getCATE_NAME(),
                category.getCATE_PARENT_ID(),
                category.getCATE_ID()});
    }

    /**
     * 删除category
     * @param id CATE_ID
     * @return 大于0表示成功
     */
    public static int categoryDelete(int id){
        String sql = "delete from CATEGORY where CATE_ID = ?";
        return BaseDao.executeIUD(sql, new Object[]{id});
    }

}