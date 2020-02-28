package tk.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {
    //在Controller的方法被执行前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("----------Before Controller Method------------");
        return true;

        //如果被拦截，可以转移或重定向到其他页面
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        //return false;
    }

    //在Controller的方法被执行后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("----------After Controller Method------------");
    }

    //在DispatcherServlet处理后执行----做一些清理工作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("----------Cleanup After Dispatch receiving the view to return------------");
    }
}
