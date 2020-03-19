package tk.springmvc.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tk.springmvc.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
}
