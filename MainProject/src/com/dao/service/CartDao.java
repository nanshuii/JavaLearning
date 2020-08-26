package com.dao.service;

import com.dao.BaseDao;
import com.entity.CART;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDao {

    /**
     * 插入一个新的CART
     * @param cart
     * @return 大于0表示成功
     */
    public static int cartAdd(CART cart) {
        String sql = "insert into CART values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[]{
                cart.getCART_USER_ID(),
                cart.getCART_PRO_ID(),
                cart.getCART_PRO_NAME(),
                cart.getCART_PRO_PRICE(),
                cart.getCART_PRO_STOCK(),
                cart.getCART_PRO_VAILD(),
                cart.getCART_PRO_FILENAME(),
                cart.getCART_PRO_QUALITY(),
                cart.getCART_PRO_TOTAL()
        };
        return BaseDao.executeIUD(sql, params);
    }

    /**
     * 通过UserId获取CART
     * @param userId userId
     * @return CART
     */
    public static CART cartGetByUserId(int userId) {
        CART cart = null;
        String sql = "select * from CART where CART_USER_ID = ? and CART_PRO_VAILD = 1";
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cart = cartGetWithResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return cart;
    }

    /**
     * 通过userId和productId来获取CART
     * @param userId userId
     * @param productId productId
     * @return CART
     */
    public static CART cartGetByUserIdProductId(int userId, int productId) {
        CART cart = null;
        String sql = "select * from CART where CART_USER_ID = ? and CART_PRO_ID = ? and CART_PRO_VAILD = 1";
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, productId);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cart = cartGetWithResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return cart;
    }

    /**
     * 通过userId获取该用户的全部购物车信息
     * @param userId userId
     * @return ArrayList<CART>
     */
    public static ArrayList<CART> cartSelect(int userId) {
        ArrayList<CART> carts = new ArrayList<CART>();
        String sql = "select * from CART where CART_USER_ID = ? and CART_PRO_VAILD = 1";
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CART cart = cartGetWithResultSet(resultSet);
                if (cart != null) {
                    carts.add(cart);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return carts;
    }

    /**
     * 从ResultSet中获取CART
     * @param resultSet
     * @return
     */
    private static CART cartGetWithResultSet(ResultSet resultSet) {
        CART cart = null;
        try {
            cart = new CART(
                    resultSet.getInt("CART_ID"),
                    resultSet.getInt("CART_USER_ID"),
                    resultSet.getInt("CART_PRO_ID"),
                    resultSet.getString("CART_PRO_NAME"),
                    resultSet.getFloat("CART_PRO_PRICE"),
                    resultSet.getInt("CART_PRO_STOCK"),
                    resultSet.getInt("CART_PRO_VAILD"),
                    resultSet.getString("CART_PRO_FILENAME"),
                    resultSet.getInt("CART_PRO_QUALITY"),
                    resultSet.getFloat("CART_PRO_TOTAL")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    /**
     * 更新商品的数量，总价
     * @param quality
     * @param total
     * @param cateId
     * @return 大于0表示成功
     */
    public static int cartUpdateWithQualityTotal(int quality, float total, int cartId) {
        String sql = "update CART set CART_PRO_QUALITY = ?, CART_PRO_TOTAL = ? where CART_ID = ?";
        Object[] params = new Object[]{
                quality,
                total,
                cartId
        };
        return BaseDao.executeIUD(sql, params);
    }
}
