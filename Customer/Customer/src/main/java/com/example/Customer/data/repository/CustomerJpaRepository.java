package com.example.Customer.data.repository;

import com.example.Customer.service.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);
}
