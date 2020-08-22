package com.http.servlet.category;

import com.dao.service.CategoryDao;
import com.entity.CATEGORY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/admin_doCateAdd")
public class DoCateAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String parentId = req.getParameter("parentId");
        String name = req.getParameter("name");
        CATEGORY category = new CATEGORY(0, name, Integer.parseInt(parentId));
        int count = CategoryDao.categoryAdd(category);
        resp.sendRedirect("admin_cateSelect");
    }
}
