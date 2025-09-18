package com.example.Customer.data;

import com.example.Customer.service.Customer;

import java.time.LocalDate;
import java.util.List;

public interface StorageService {

    Customer saveCustomer(Customer customer);
    List<Customer> findAll();
    Customer findById(Long id);
    void deleteById(Long id);
    List<Customer> findCustomersBornBetween(LocalDate startDate, LocalDate endDate);
}
