package ie.atu.week5.customerapp.Customer;

import ie.atu.week5.customerapp.Customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
