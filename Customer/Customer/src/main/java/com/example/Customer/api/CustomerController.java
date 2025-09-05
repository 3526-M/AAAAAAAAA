package com.example.Customer.api;



import com.example.Customer.api.dto.CustomerDto;
import com.example.Customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/saveCustomer")
class CustomerController
{
    private final CustomerService service;
    public CustomerController(CustomerService service)
    {
        this.service = service;
    }
    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customer) {
        return service.save(customer);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/createBulkCustomer")
    public List<CustomerDto> createBulkCustomer(@RequestBody int amount) {
        return service.createBulkCustomer(amount);

    }
}






