package com.example.Customer.api.dto;

public class TimedFindCustomerResponse {
    CustomerDto customer;
    long elapsedTime;


    public TimedFindCustomerResponse(CustomerDto customer, long elapsedTime) {
        this.customer = customer;
        this.elapsedTime = elapsedTime;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

}
