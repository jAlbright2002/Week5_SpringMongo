package ie.atu.week5.customerapp.CustomerOrder;

import ie.atu.week5.customerapp.Customer.CustomerService;
import ie.atu.week5.customerapp.Order.Order;
import ie.atu.week5.customerapp.Order.OrderService;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {

    private final CustomerService customerService;

    private final OrderService orderService;

    public CustomerOrderService(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    public void createNewCustomerWithNewOrders(CustomerOrderRequest customerOrderRequest) {
        customerService.createCustomer(customerOrderRequest.getCustomer());
        String customerId = customerOrderRequest.getCustomer().getId();

        for (Order order : customerOrderRequest.getOrders()) {
            order.setCustomerId(customerId);
            orderService.createOrder(order);
        }
    }

}
