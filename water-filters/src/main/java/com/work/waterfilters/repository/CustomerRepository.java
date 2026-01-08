package com.work.waterfilters.repository;

import com.work.waterfilters.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
    Customer findByEmail(String email);
    Optional<Customer> findByPhone(String phone);
}