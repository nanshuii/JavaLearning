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
        ArrayList<PRODUCT> products = new ArrayList<PRODUCT>();
        String sql = "select * from PRODUCT";
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
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
