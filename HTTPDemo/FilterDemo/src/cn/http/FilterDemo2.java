package cn.http;

import javax.servlet.*;
import java.io.IOException;

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
