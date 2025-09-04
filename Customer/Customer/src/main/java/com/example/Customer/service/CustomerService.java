package com.example.Customer.service;

import com.example.Customer.api.dto.CustomerDto;
import com.example.Customer.data.CustomerStorage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerStorage storage;

    public CustomerService(CustomerStorage storage) {
        this.storage = storage;
    }

        public CustomerDto save(CustomerDto customerDto) {


            Customer c = new Customer();
            c.setName(customerDto.getName());
            c.setSurname(customerDto.getSurname());
            c.setBirthDate(customerDto.getBirthDate());
            Customer savedCustomer = storage.saveCustomer(c);
            return customerDto;
        }


    public List<CustomerDto> findAll() {
        List<CustomerDto> dtos = new ArrayList<>();
        for (Customer c : storage.findAll()) {
            CustomerDto dto = new CustomerDto();
            dto.setName(c.getName());
            dto.setSurname(c.getSurname());
            dto.setBirthDate(c.getBirthDate());
            dtos.add(dto);
        }
        return dtos;
    }

    public CustomerDto findById(Long id) {
        for (Customer c : storage.findAll()) {
            if (c.getId().equals(id)) {
                CustomerDto dto = new CustomerDto();
                dto.setName(c.getName());
                dto.setSurname(c.getSurname());
                dto.setBirthDate(c.getBirthDate());
                return dto;
            }
        }
        return null;
    }

        public void deleteById(Long id) {
            storage.deleteById(id);
        }
    }

