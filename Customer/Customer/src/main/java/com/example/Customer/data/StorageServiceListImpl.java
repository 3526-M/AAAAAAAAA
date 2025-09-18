package com.example.Customer.data;


import com.example.Customer.service.Customer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ConditionalOnProperty(
        name = "customer_service.fast_fetch_enabled",
        havingValue = "false"
)
@Service
public class StorageServiceListImpl implements StorageService {


    private final List<Customer> customers = new ArrayList<>();
    private long idCounter = 0;

    @Override
    public Customer saveCustomer(Customer customer) {
        if(customer.getId()==null){
            customer.setId(idCounter);
            idCounter++;
        }
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void  deleteById(Long id){
        customers.removeIf(customer -> customer.getId().equals(id));
    }

    public List<Customer> findCustomersBornBetween(LocalDate startDate, LocalDate endDate ){
        throw new UnsupportedOperationException("No");
    }

}
