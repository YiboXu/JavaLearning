package tk.springmvc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tk.springmvc.api.exception.OrderNotFoundException;
import tk.springmvc.model.Order;
import tk.springmvc.service.OrderService;
import tk.springmvc.model.Error;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    //http://localhost:8080/orders?id=5e58bcf532d2b736c4082f92
    @GetMapping
    public List<Order> listOrders(@RequestParam(value="id",required=false)String id){
        if(id == null)
            return orderService.selectAll();
        else {
            Optional<Order> torder = orderService.selectById(id);
            if(torder.isPresent()){
                return Arrays.asList(torder.get());
            }else{
                return Arrays.asList();
            }
        }
    }

    //http://localhost:8080/orders/5e58bcf532d2b736c4082f92
    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable String id){
        Optional<Order> torder = orderService.selectById(id);
        if(torder.isPresent()){
            return torder.get();
        }else{
            //抛出异常，orderNotFound方法会被触发执行返回ResponseEntity<Error>
            throw new OrderNotFoundException(id);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order, UriComponentsBuilder ucb){
        Order insertedOrder = orderService.insertOrder(order);

        HttpHeaders headers = new HttpHeaders();

        URI locationUri =
                ucb.path("/orders/")
                        .path(String.valueOf(order.getId()))
                        .build()
                        .toUri();

        headers.setLocation(locationUri);

        ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(insertedOrder, headers, HttpStatus.CREATED);

        return responseEntity;
    }

    //@ExceptionHandler的用法: 其注释的方法所在的Controller的任意一个handler method抛出OrderNotFoundException异常，就会调用其注释的方法
    //也就是说OrderController任意一个handler method抛出OrderNotFoundException异常，就会执行下面的orderNotFound方法
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error orderNotFound(OrderNotFoundException e) {
        String orderId = e.getOrderId();
        Error error = new Error(4, "Spittle [" + orderId + "] not found");
        return error;
    }

    /* 通过返回ResponseEntity来指定各种不同的返回码
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Error> orderNotFound(
            OrderNotFoundException e) {
        String orderId = e.getOrderId();
        Error error = new Error(4, "Spittle [" + orderId + "] not found");
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
     */

    public static String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme() + "://";
        String serverName = request.getServerName();
        String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
        String contextPath = request.getContextPath();
        return scheme + serverName + serverPort + contextPath;
    }
}
