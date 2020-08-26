package com.http.servlet.home;

import com.dao.service.CartDao;
import com.entity.CART;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cartUpdate")
public class cartUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String quality = req.getParameter("quality");
        String cartId = req.getParameter("cartId");
        String price = req.getParameter("price");
        if (price != null && price.contains("￥")) {
            price = price.substring(1);
        }
        System.out.println(price);
        if (type != null && type.equals("numberUpdate")) {
            float total = Integer.parseInt(quality) * Float.parseFloat(price);
            int count = CartDao.cartUpdateWithQualityTotal(Integer.parseInt(quality), total, Integer.parseInt(cartId));
            System.out.println("number update 数量 = " + quality + " cartId = " + cartId + " total = " + total);
        }
    }
}
