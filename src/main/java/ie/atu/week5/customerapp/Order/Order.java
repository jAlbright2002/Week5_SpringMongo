package ie.atu.week5.customerapp.Order;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    @Digits(message = "Order code must be 4 digits long", integer = 4, fraction = 0)
    private int orderCode;
    @NotBlank(message = "Order details must not be blank")
    private String orderDetails;
    @DateTimeFormat(pattern = "YYYY-DD-MM")
    private String orderDate;

    private String customerId;
}
