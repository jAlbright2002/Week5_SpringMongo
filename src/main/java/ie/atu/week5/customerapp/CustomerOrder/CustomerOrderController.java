package ie.atu.week5.customerapp.CustomerOrder;

import ie.atu.week5.customerapp.Customer.CustomerRepository;
import ie.atu.week5.customerapp.Customer.CustomerService;
import ie.atu.week5.customerapp.Order.Order;
import ie.atu.week5.customerapp.Order.OrderRepository;
import ie.atu.week5.customerapp.Order.OrderService;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerOrderController {

    private final CustomerService customerService;

    private final OrderService orderService;

    public CustomerOrderController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @PostMapping("/customer-with-orders")
    public ResponseEntity<String> createCustomerWithOrders(@RequestBody CustomerOrderRequest customerOrderRequest) {

        // 1. Save the Customer and get the generated customer ID
        customerService.createCustomer(customerOrderRequest.getCustomer());
        String customerId = customerOrderRequest.getCustomer().getId();

        // 2. Save the Orders and link them to the customer
        for (Order order : customerOrderRequest.getOrders()) {
            order.setCustomerId(customerId);
            orderService.createOrder(order);
        }

        return ResponseEntity.ok("Customer and orders created successfully");
    }
}
