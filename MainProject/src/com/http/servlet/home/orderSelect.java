package com.http.servlet.home;

import com.dao.service.CartDao;
import com.entity.CART;
import com.entity.USER;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/orderSelect")
public class orderSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("ids");
        String[] idsArr = ids.split(",");
        HttpSession session = req.getSession();
        Integer isLogin = (Integer) session.getAttribute("isLogin");
        System.out.println("isLogin = " + isLogin);
        // 判断是否登录
        if (isLogin != null && isLogin == 1) {
            USER user = (USER)session.getAttribute("login_user");
            // 获取购物车信息
            ArrayList<CART> carts = CartDao.cartSelectByCartIds(idsArr);
            req.setAttribute("cart_list", carts);
            req.getRequestDispatcher("order.jsp").forward(req, resp);
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
}
