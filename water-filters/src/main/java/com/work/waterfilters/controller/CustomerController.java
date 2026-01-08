package com.work.waterfilters.controller;

import com.work.waterfilters.dto.CustomerDTO;
import com.work.waterfilters.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*") // optional, allows frontend access
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customerDTO = service.getCustomerById(id);
        return ResponseEntity.ok(customerDTO);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return new ResponseEntity<>(service.createCustomer(customerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerDTO customerDTO) {
        try {
            return ResponseEntity.ok(service.updateCustomer(id, customerDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
