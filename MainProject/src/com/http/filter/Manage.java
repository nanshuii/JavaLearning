package com.http.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/manage/*")
public class Manage implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取session，获取标识位
        HttpSession session = request.getSession();
        Object ial = session.getAttribute("isAdminLogin");
        String isAdminLogin = null;
        if (ial != null) {
            isAdminLogin = ial.toString();
        }
        System.out.println("is admin login = " + isAdminLogin);
        // 对登录页面,css,js的排除
        String uri = request.getRequestURI(); // /MainProject_war_exploded/manage/admin_login.jsp
        String contextPath = request.getContextPath(); // /MainProject_war_exploded
        String url = uri.substring(contextPath.length()); // /manage/admin_login.jsp
        System.out.println(url);
        if (uri.contains("/manage/css") || uri.contains("/manage/js") || uri.contains("/manage/fonts") || uri.contains("/manage/images")) {
            chain.doFilter(req, resp);
        } else {
            if (isAdminLogin != null && isAdminLogin.equals("1")) {
                // 已登录的状态
                chain.doFilter(req, resp);
            } else if (url.equals("/manage/admin_login") || url.equals("/manage/admin_login.jsp")) {
                chain.doFilter(req, resp);
            }
            else {
                System.out.println("to login");
                PrintWriter printWriter = resp.getWriter();
                printWriter.write("<script>");
                printWriter.write("alert('请先登录');");
                printWriter.write("location.href='admin_login.jsp';");
                printWriter.write("</script>");
                printWriter.close();
                return;
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
