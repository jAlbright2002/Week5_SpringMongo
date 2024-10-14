package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public ResponseEntity<Customer> getCustomerById(String id) {
        if (repository.findById(id).isPresent()) {
            return ResponseEntity.ok(repository.findById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public ResponseEntity<Void> deleteCustomer(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
