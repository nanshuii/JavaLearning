package com.http.servlet.user;

import com.dao.service.UserDao;
import com.entity.USER;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/manage/admin_doUserSelect")
public class DoUserSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = 1; // 当前页
        int count = 2; // 每页显示条数
        // 获取用户指定的页面
        String cp = req.getParameter("cp");
        if (cp != null) {
            currentPage = Integer.parseInt(cp);
        }
        req.setAttribute("currentPage", currentPage);
        // 接收用户搜索的关键字
        String keywords = req.getParameter("keywords");
        if (keywords != null) {
            req.setAttribute("keywords", "&keywords="+keywords);
        }
        // 总记录数和总页数
        int arr[] = UserDao.totalPage(count, keywords);
        req.setAttribute("totalPage", arr[1]);
        req.setAttribute("totalNum", arr[0]);
        // 获取所有用户记录
//        ArrayList<USER> users = UserDao.selectAll();
        ArrayList<USER> users = UserDao.selectPage(currentPage, count, keywords);
        System.out.println("users = " + users.toString());
        // 放到请求对象域里
        req.setAttribute("users", users);
        // 转发
        req.getRequestDispatcher("admin_user.jsp").forward(req, resp);
    }
}
