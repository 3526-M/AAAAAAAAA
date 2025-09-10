package com.example.Customer.data;

import com.example.Customer.service.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageServiceFastFetchImpl implements StorageService {


    private final Map<Long, Customer> customers = new HashMap<>();
    private long idCounter = 0;
    public Customer saveCustomer(Customer customer) {
        if (customer.getId() == null) {
            idCounter++;
            customer.setId(idCounter++);
        }
        customers.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(Long id) {
        return customers.get(id);
    }
    @Override
    public void deleteById(Long id) {
        customers.remove(id);
    }

}
