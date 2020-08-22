package com.http.servlet.category;

import com.dao.service.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/admin_doCateDelete")
public class DoCateDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        CategoryDao.categoryDelete(Integer.parseInt(id));
        resp.sendRedirect("admin_cateSelect");
    }
}
