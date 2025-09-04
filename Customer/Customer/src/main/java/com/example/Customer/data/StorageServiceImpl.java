package com.example.Customer.data;


import com.example.Customer.service.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StorageServiceImpl implements StorageService {


    private final List<Customer> customers = new ArrayList<>();
    private long idCounter = 0;

    @Override
    public Customer saveCustomer(Customer customer) {
        if(customer.getId()==null){
            idCounter++;
            customer.setId(idCounter);
            customer.setId(idCounter);
        }
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
    public Customer findById(Long id){
        for(Customer customer : customers){
            if(customer.getId().equals(id)){
            return customer;
            }
        }
        return null;
    }

    public Customer findById(String id){
        for(Customer customer : customers){
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }
    public void  deleteById(Long id){
        customers.removeIf(customer -> customer.getId().equals(id));

    }


}
