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

@WebServlet(urlPatterns = "/manage/admin_cateUpdate")
public class CateUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        CATEGORY category = CategoryDao.selectCategoryById(Integer.parseInt(id));
        System.out.println("cate = " + category);
        ArrayList<CATEGORY> categories = CategoryDao.selectAll();
        req.setAttribute("current_cate", category);
        req.setAttribute("cate_list", categories);
        req.getRequestDispatcher("admin_cateUpdate.jsp").forward(req, resp);
    }
}
