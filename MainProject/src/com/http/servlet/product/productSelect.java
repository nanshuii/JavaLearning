package com.http.servlet.product;

import com.dao.service.ProductDao;
import com.entity.PRODUCT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/manage/admin_productSelect")
public class productSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<PRODUCT> products = ProductDao.selectAll();
        req.setAttribute("product_list", products);
        req.getRequestDispatcher("admin_product.jsp").forward(req, resp);
    }
}
