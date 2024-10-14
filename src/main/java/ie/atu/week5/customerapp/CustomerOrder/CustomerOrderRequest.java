package ie.atu.week5.customerapp.CustomerOrder;

import ie.atu.week5.customerapp.Customer.Customer;
import ie.atu.week5.customerapp.Order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderRequest {

    private Customer customer;
    private List<Order> orders;

}
