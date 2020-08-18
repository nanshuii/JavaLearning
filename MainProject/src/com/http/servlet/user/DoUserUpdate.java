package com.http.servlet.user;

import com.dao.service.UserDao;
import com.entity.USER;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manage/admin_doUserUpdate")
public class DoUserUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取用户id，数据库查找用户
        String userId = req.getParameter("id");
        USER user = UserDao.selectById(userId);
        req.setAttribute("user", user);
        // 获取currentPage和keywords并且保存到request域中
        String currentPage = req.getParameter("cp");
        String keywords = req.getParameter("keywords");
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("keywords", keywords);
        // 转发
        req.getRequestDispatcher("admin_userModeify.jsp").forward(req, resp);
    }
}
