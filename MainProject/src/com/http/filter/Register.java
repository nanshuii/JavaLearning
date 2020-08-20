package com.http.filter;

import com.dao.service.UserDao;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/register")
public class Register implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 转换req和resp
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        // 设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取打印流
        PrintWriter printWriter = response.getWriter();
        // 获取参数进行判断
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        if (username == null || username.equals("")) {
            printWriter.write("<script>");
            printWriter.write("alert('用户名为空');");
            printWriter.write("location.href='reg.jsp'");
            printWriter.write("</script>");
            printWriter.close();
            return;
        } else {
            int count = UserDao.selectByUsername(username);
            if (count > 0) {
                printWriter.write("<script>");
                printWriter.write("alert('用户名已存在');");
                printWriter.write("location.href='reg.jsp'");
                printWriter.write("</script>");
                printWriter.close();
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
