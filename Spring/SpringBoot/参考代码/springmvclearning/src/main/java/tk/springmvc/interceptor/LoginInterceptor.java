package tk.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    private List<String> allowedUrl;

    public void setAllowedUrl(List<String> allowedUrl) {
        this.allowedUrl = allowedUrl;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果已经登录过，就直接通过
        Object user = request.getSession().getAttribute("user");
        if(user != null){
            return true;
        }
        //如果没有登录过，就判断是否是不需要登录的URL
        /**
         * request.getRequestURL() http://localhost:8080/jqueryLearn/resources/request.jsp
         * request.getRequestURI() /jqueryLearn/resources/request.jsp
         * request.getContextPath()/jqueryLearn
         * request.getServletPath()/resources/request.jsp
         */
        String requestUrl = request.getServletPath();

        for(String url : allowedUrl){
            if(requestUrl.startsWith(url)){
                return true;
            }
        }

        //对于需要登录的URL,
        // 重定向到登录页面
        //response.sendRedirect("/login");
        //或者转发到登录页面，登录后在重新转发到原来访问的URL
        request.setAttribute("requestUrl",requestUrl);
        request.getRequestDispatcher("/myLogin").forward(request,response);
        return false;
    }
}
