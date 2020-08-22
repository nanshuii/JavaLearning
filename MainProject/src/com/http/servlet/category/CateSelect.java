package com.http.servlet.category;

import com.dao.service.CategoryDao;
import com.entity.CATEGORY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/manage/admin_cateSelect")
public class CateSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<CATEGORY> categories = CategoryDao.selectAll();
        System.out.println("cate list = " + categories);
        req.setAttribute("cate_list", categories);
        req.getRequestDispatcher("admin_cate.jsp").forward(req, resp);
    }
}
