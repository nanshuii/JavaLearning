package com.http.servlet.home;

import com.dao.service.CartDao;
import com.dao.service.ProductDao;
import com.entity.CART;
import com.entity.PRODUCT;
import com.entity.USER;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cartAdd")
public class carAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String productId = req.getParameter("productId");
        String buy = req.getParameter("buy");
        String count = req.getParameter("count");

        // 获取用户
        HttpSession session = req.getSession();
        Integer isLogin = (Integer) session.getAttribute("isLogin");
        System.out.println("isLogin = " + isLogin);
        // 判断是否登录
        if (isLogin != null && isLogin == 1) {
            USER user = (USER)session.getAttribute("login_user");
            // 获取产品信息
            PRODUCT product = ProductDao.productGetById(Integer.parseInt(productId));
            // 查询是否原来有这条记录
            int success = 0;
            CART cart = CartDao.cartGetByUserIdProductId(Integer.parseInt(user.getUSER_ID()), product.getPRODUCT_ID());
            if (cart != null) {
                // 原购物车有这条商品的信息，做叠加
                int cart_quality = cart.getCART_PRO_QUALITY() + Integer.parseInt(count);
                float total = cart_quality * product.getPRODUCT_PRICE();
                success = CartDao.cartUpdateWithQualityTotal(cart_quality, total, cart.getCART_ID());
            } else {
                float total = Float.parseFloat(count) * product.getPRODUCT_PRICE();
                cart = new CART(
                        0,
                        Integer.parseInt(user.getUSER_ID()),
                        product.getPRODUCT_ID(),
                        product.getPRODUCT_NAME(),
                        product.getPRODUCT_PRICE(),
                        product.getPRODUCT_STOCK(),
                        1,
                        product.getPRODUCT_FILENAME(),
                        Integer.parseInt(count),
                        total
                );
                success = CartDao.cartAdd(cart);
            }
            if (success > 0) {
                // cart存在
                if (Integer.parseInt(buy) == 1) {
                    // 去购买
                    resp.sendRedirect("productDetail?id=" + productId);
                } else {
                    // 去购物车
                    resp.sendRedirect("cartSelect");
                }
            } else {
                cartAddFail(req, resp, productId);
            }
        } else {
            toLogin(req, resp);
        }
    }

    /**
     * 去登录
     */
    private void toLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<script>");
        printWriter.write("alert('请登录');");
        printWriter.write("location.href='login.jsp';");
        printWriter.write("</script>");
        printWriter.close();
    }

    /**
     * 添加失败，返回
     */
    private void cartAddFail(HttpServletRequest req, HttpServletResponse resp, String productId) throws IOException{
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<script>");
        printWriter.write("alert('添加失败');");
        printWriter.write("location.href='productDetail?id=" + productId + "';");
        printWriter.write("</script>");
        printWriter.close();
    }
}
