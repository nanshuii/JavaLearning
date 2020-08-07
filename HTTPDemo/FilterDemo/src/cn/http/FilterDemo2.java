package cn.http;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter demo2");
    }

    @Override
    public void destroy() {

    }
}
