package tk.billhu.gulimall.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.billhu.gulimall.common.service.WareFeignService;

import java.util.Map;

@RestController
@RequestMapping("/product")
@RefreshScope//nacos配置中心时添加上
public class FeignTest {
    @Autowired
    private WareFeignService wareFeignService;

    @Value("${myusername}")
    private String name;
    @Value("${myuserage}")
    private int age;

    @RequestMapping("/test/ware")
    public String ware(@RequestParam Map<String, Object> params){
        return wareFeignService.list(params).toString();
    }

    @RequestMapping("/test/value")
    public String value(){
        return "myusername: "+name+", age: "+age;
    }
}
