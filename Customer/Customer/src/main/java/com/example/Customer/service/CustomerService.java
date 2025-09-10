package com.example.Customer.service;

import com.example.Customer.api.dto.CustomerDto;
import com.example.Customer.data.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CustomerService {

    private final StorageService storage;



    @Autowired
    public CustomerService(StorageService storage) {
        this.storage = storage;
    }

    public List<CustomerDto> createBulkCustomer(int amount) {
        List<CustomerDto> dtos = new ArrayList<>();

        Random random = new Random();

        String[] names = {"Murat", "Husnu", "Karabas", "Barıs", "Ayse", "Esra"};
        String[] surnames = {"Samet", "Burak", "Camur", "Akturk", "Baran"};
        for (int i = 0; i < amount; i++) {
            CustomerDto dto = new CustomerDto();
            dto.setName(names[random.nextInt(names.length)]);
            dto.setSurname(surnames[random.nextInt(surnames.length)]);

            int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
            long randomDay = minDay + random.nextInt(maxDay - minDay);

            LocalDate birthDate = LocalDate.ofEpochDay(randomDay);
            dto.setBirthDate(birthDate);

            Customer c = new Customer();
            c.setName(dto.getName());
            c.setSurname(dto.getSurname());
            c.setBirthDate(birthDate);
            storage.saveCustomer(c);
            dtos.add(dto);

        }
        return dtos;
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
        Customer c = storage.findById(id);
        if (c == null) {
            return null;
        }
        CustomerDto dto = new CustomerDto();
        dto.setName(c.getName());
        dto.setSurname(c.getSurname());
        dto.setBirthDate(c.getBirthDate());
        return dto;

    }

    public void deleteById(Long id) {
        storage.deleteById(id);
    }

}




