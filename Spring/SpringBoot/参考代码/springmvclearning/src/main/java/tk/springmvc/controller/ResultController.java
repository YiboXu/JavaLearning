package tk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ResultController {
    @RequestMapping("/result1")
    public void result1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Result returned from ResultController!");
    }

    @RequestMapping("/result2")
    public void result2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //*这里不能重定向到WEB-INF/views里面的jsp,只能重定向到webapp下面的其他目录
        //*这个时因为WEB-INF只能由应用程序内部访问，比如我们页面渲染器，但是作为客户端是不能直接访问的.
        //*重定向 url会改变
        response.sendRedirect("redirect/result.jsp");
    }

    @RequestMapping("/result3")
    public void result3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("parm1","valueOfParm1");
        //*这里不能重定向到WEB-INF/views里面的jsp,只能重定向到webapp下面的其他目录
        //*这个时因为WEB-INF只能由应用程序内部访问，比如我们页面渲染器，但是作为客户端是不能直接访问的.
        //转发， url不会改变
        //这种方式转发是不会经过视图解析器渲染的，也就是不会被添加前后缀
        request.getRequestDispatcher("redirect/result.jsp").forward(request,response);
    }

    @RequestMapping("/result4")
    public String result4(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //*因为有视图解析器，所以这里只用返回一个index,然后视图解析器会加上前缀和后缀，从而访问到/WEB-INF/views/index.jsp
        //*如果没有视图解析器，这里需要指定完整的路径 比如 return "static/result.jsp"
        //转发， url不会改变
        return "index";
    }

    @RequestMapping("/result5")
    public String result5(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //*不会经过视图解析器，等效于http://locahost:8080/static/result.jsp
        //转发， url不会改变
        return "forward:redirect/result.jsp";
    }

    @RequestMapping("/result6")
    public String result6(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //*跳转到新的页面
        //*不会经过视图解析器，等效于http://locahost:8080/static/result.jsp
        //重定向， url会改变
        return "redirect:redirect/result.jsp";
    }

    @RequestMapping("/result7")
    public String result7(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //转发， url不会改变，request里面的信息会传递过去
        request.setAttribute("msg","test-message");
        return "forward:/add";
    }

    @RequestMapping("/result8")
    public String result8(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //重定向， url会改变，request里面的信息不会传递过去
        request.setAttribute("msg","test-message");
        return "redirect:/add";
    }

    /**
     * 总结：
     * 1. 没有redirect的 return,都属于转发
     * 2. 对于 return "forward:url"这样的转发，是不经过视图解析器的，相当于将请求发送到新的url，由对应的controller来处理
     * 3. 对于 return "viewName"这样的转发，如果有视图解析器，就会通过其添加前缀和后缀，所以转发到请求都了页面WEB-INF/views/viewName.jsp
     *      *             如果没有视图解析器，就不会自动添加前缀和后缀，这个时候返回值里面需要包含前后缀， 比如 return "redirect/result.jsp
     * 4. 对于 return "redirect:url,属于重定向，当于重新在浏览器上更改url，不会经过视图解析器，所以return的值需要时一个合法的能够被处理的url
     * 5. 对于转发，request里面的信息会传递过去; 对于重定向，request里面的信息不会传递过去.
     * 6. request.getRequestDispatcher("redirect/result.jsp").forward(request,response);这种方式不会被视图解析器添加前后缀
     */

}
