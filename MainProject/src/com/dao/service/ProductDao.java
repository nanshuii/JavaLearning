package com.dao.service;

import com.dao.BaseDao;
import com.entity.PRODUCT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {

    /**
     * 插入一条Product
     * @param product product
     * @return 大于0表示成功
     */
    public static int productInsert(PRODUCT product) {
        String sql = "insert into PRODUCT values(null, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[]{
                product.getPRODUCT_NAME(),
                product.getPRODUCT_DESC(),
                product.getPRODUCT_PRICE(),
                product.getPRODUCT_STOCK(),
                product.getPRODUCT_FID(),
                product.getPRODUCT_CID(),
                product.getPRODUCT_FILENAME()
        };
        return BaseDao.executeIUD(sql, params);
    }

    /**
     * 获取所有的PRODUCT
     * @return ArrayList<PRODUCT>
     */
    public static ArrayList<PRODUCT> selectAll() {
        String sql = "select * from PRODUCT";
        return select(sql, -1, -1);
    }

    /**
     * 筛选分类获取PRODUCT
     * @param parentId 父分类；
     * @param childId 子分类；-1时表示不筛选子分类
     * @return
     */
    public static ArrayList<PRODUCT> selectByCateId(int parentId, int childId) {
        String sql = "select * from PRODUCT where PRODUCT_FID = ?";
        if (childId != -1) {
            sql = "select * from PRODUCT where PRODUCT_FID = ? and PRODUCT_CID = ?";
        }
        return select(sql, parentId, childId);
    }

    /**
     * 选择商品
     * @param sql sql
     * @param parentId 父分类；
     * @param childId 子分类；-1时表示不筛选子分类
     * @return ArrayList<PRODUCT>
     */
    private static ArrayList<PRODUCT> select(String sql, int parentId, int childId) {
        ArrayList<PRODUCT> products = new ArrayList<PRODUCT>();
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (parentId == -1 && childId == -1) {
                // 全部商品

            } else if (parentId != -1 && childId == -1) {
                // 只选择父分类的
                preparedStatement.setInt(1, parentId);
            } else if (parentId != -1 && childId != -1) {
                // 选择父分类和子分类的
                preparedStatement.setInt(1, parentId);
                preparedStatement.setInt(2, childId);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PRODUCT product = productByResultSet(resultSet);
                if (product != null) {
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return products;
    }

    /**
     * 通过id查询PRODUCT
     * @param id id
     * @return PRODUCT
     */
    public static PRODUCT productGetById(int id) {
        PRODUCT product = null;
        String sql = "select * from PRODUCT where PRODUCT_ID = ?";
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = productByResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return product;
    }




    /**
     * 通过resultSet获取product
     * @param resultSet resultSet
     * @return PRODUCT
     */
    private static PRODUCT productByResultSet(ResultSet resultSet){
        PRODUCT product = null;
        try {
            product = new PRODUCT(
                    resultSet.getInt("PRODUCT_ID"),
                    resultSet.getString("PRODUCT_NAME"),
                    resultSet.getString("PRODUCT_DESC"),
                    resultSet.getFloat("PRODUCT_PRICE"),
                    resultSet.getInt("PRODUCT_STOCK"),
                    resultSet.getInt("PRODUCT_FID"),
                    resultSet.getInt("PRODUCT_CID"),
                    resultSet.getString("PRODUCT_FILENAME")
                    );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
