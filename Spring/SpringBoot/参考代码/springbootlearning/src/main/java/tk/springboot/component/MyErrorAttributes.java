package tk.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("author","BillHu");

        //获取在MyExceptionHandler中添加的异常信息
        Map<String,Object> ext = (Map<String,Object>) webRequest.getAttribute("ext",0);
        map.put("ext",ext);

        return map;
    }


}
