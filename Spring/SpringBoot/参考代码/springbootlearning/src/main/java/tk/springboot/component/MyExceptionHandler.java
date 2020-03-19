package tk.springboot.component;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tk.springboot.exception.EmployeeNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleException(Exception e, HttpServletRequest request){

        Map<String,String> map = new HashMap<String, String>();
        map.put("code","employee.notfound");
        map.put("message",e.getMessage());
        request.setAttribute("javax.servlet.error.status_code",500);
        request.setAttribute("ext",map);

        return "forward:/error";
    }
}
