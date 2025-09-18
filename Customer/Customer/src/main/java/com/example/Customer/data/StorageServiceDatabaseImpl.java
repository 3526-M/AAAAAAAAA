package com.example.Customer.data;

import com.example.Customer.data.repository.CustomerJpaRepository;
import com.example.Customer.service.Customer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@ConditionalOnProperty(
        name = "customer_service.fast_fetch_enabled",
        havingValue = "database"
)
@Service
public class StorageServiceDatabaseImpl implements StorageService {

    private final CustomerJpaRepository repository;

    public StorageServiceDatabaseImpl(CustomerJpaRepository repository) {
        this.repository = repository;
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }


    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Customer> findCustomersBornBetween(LocalDate startDate, LocalDate endDate) {
        return repository.findByBirthDateBetween(startDate, endDate);
    }
}
