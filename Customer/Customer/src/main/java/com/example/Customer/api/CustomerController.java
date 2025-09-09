package com.example.Customer.api;



import com.example.Customer.api.dto.CreateBulkCustomersRequestDto;
import com.example.Customer.api.dto.CustomerDto;
import com.example.Customer.api.dto.CustomerIdRequest;
import com.example.Customer.api.dto.TimedFindCustomerResponse;
import com.example.Customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping("/findCustomerById")
    public TimedFindCustomerResponse getCustomerById(@RequestBody CustomerIdRequest customerIdRequest) {
        long startTime = System.nanoTime();
        CustomerDto customer = service.findById(customerIdRequest.getId());

        if (customer == null) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println((elapsedTime / 1000000.0) + " ms");
        long elapsedTimeMs = (elapsedTime / 1000000);
        return new TimedFindCustomerResponse(customer, elapsedTimeMs);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteById(id);
    }


    @PostMapping("/createBulkCustomer")
    public List<CustomerDto> createBulkCustomersRequestDto(@RequestBody CreateBulkCustomersRequestDto createBulkCustomersRequestDto) {
        return service.createBulkCustomer(createBulkCustomersRequestDto.getAmount());

    }
}






