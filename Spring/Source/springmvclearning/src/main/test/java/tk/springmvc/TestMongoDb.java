package tk.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.springmvc.model.Item;
import tk.springmvc.model.Order;
import tk.springmvc.service.OrderService;

import java.util.Arrays;

public class TestMongoDb {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        Item item1 = new Item();
        item1.setProduct("iphone1");
        item1.setQuantity(1);
        item1.setPrice(1000);

        Item item2 = new Item();
        item2.setProduct("iphone2");
        item2.setQuantity(2);
        item2.setPrice(2000);

        Item item3 = new Item();
        item3.setProduct("iphone3");
        item3.setQuantity(3);
        item3.setPrice(3000);

        Order order = new Order();
        order.setCustomer("SoficaYang");
        order.setType("Customer Order");
        order.setItems(Arrays.asList(item1,item2,item3));

        orderService.insertOrder(order);

        orderService.selectAll().stream().forEach(System.out::println);
    }
}
