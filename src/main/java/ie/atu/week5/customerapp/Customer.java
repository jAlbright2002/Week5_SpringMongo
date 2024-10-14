package ie.atu.week5.customerapp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    @NotBlank(message = "Name must not be empty")
    private String name;
    @Email(message = "Email must be valid with @ included")
    private String email;
}