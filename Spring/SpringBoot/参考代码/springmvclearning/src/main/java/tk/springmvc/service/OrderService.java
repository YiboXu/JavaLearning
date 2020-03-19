package tk.springmvc.service;

import tk.springmvc.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> selectAll();
    Order insertOrder(Order order);
    Optional<Order> selectById(String id);
}
