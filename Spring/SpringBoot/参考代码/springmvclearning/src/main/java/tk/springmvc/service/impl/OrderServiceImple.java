package tk.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springmvc.model.Order;
import tk.springmvc.mongodb.repository.OrderRepository;
import tk.springmvc.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service("orderService")
public class OrderServiceImple implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> selectAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order insertOrder(Order order) {
        return orderRepository.insert(order);
    }

    @Override
    public Optional<Order> selectById(String id) {
        return orderRepository.findById(id);
    }
}
