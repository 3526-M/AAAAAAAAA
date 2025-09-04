package com.example.Customer.data;

import com.example.Customer.service.Customer;

import java.util.List;

public interface CustomerStorageServiceImpl {

    Customer saveCustomer(Customer customer);
    List<Customer> findAll();
    Customer findById(Long id);
    void deleteById(Long id);

}
