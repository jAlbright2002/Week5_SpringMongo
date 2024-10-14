package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public ResponseEntity<List<Order>> getOrdersByCustomerId(String customerId) {
        List<Order> orders = repository.findByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public ResponseEntity<Void> deleteOrder(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
