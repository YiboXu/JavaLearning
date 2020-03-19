package tk.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.springboot.service.impl.AsyncService;

@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/async")
    public String async(){
        //这个hello方法会被另一个线程所提交执行
        asyncService.hello();
        //controller里面的方法会立即返回，不用等到hello()方法执行完毕
        //所以可以用hello方法提交一些比较耗时的操作，提交就不不管了，历及返回，让hello自己去处理，当然一般会提供一个功能来查看hello的处理结果
        return "porcess complete";
    }
}
