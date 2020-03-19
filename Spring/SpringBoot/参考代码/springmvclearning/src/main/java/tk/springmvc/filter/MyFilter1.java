package tk.springmvc.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter1 is starting.....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter1 starts doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilter1 completes doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter1 is destroying.....");
    }
}
