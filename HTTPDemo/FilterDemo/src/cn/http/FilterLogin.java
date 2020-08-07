package cn.http;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class FilterLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 强制转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取资源请求路径，判断是否包含登录相关资源路径
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")) {
            // 放行，去登录
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 去验证用户是否登录，从session中获取user
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                // 已经登录
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                // 没有登录，跳转登录页面
                request.setAttribute("msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
