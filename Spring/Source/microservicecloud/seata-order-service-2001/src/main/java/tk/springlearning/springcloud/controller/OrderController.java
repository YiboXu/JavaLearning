package tk.springlearning.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.springlearning.springcloud.domain.CommonResult;
import tk.springlearning.springcloud.domain.Order;
import tk.springlearning.springcloud.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    //http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100
    @RequestMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功", order);
    }
}
