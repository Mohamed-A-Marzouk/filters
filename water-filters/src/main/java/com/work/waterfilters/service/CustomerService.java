package com.work.waterfilters.service;

import com.work.waterfilters.dto.CustomerDTO;
import com.work.waterfilters.entity.Customer;
import com.work.waterfilters.exception.PhoneAlreadyExistsException;
import com.work.waterfilters.exception.ResourceNotFoundException;
import com.work.waterfilters.mapper.CustomerMapper;
import com.work.waterfilters.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public List<CustomerDTO> getAllCustomers() {
        return mapper.toDTOList(repository.findAll());
    }

    public CustomerDTO getCustomerById(Long id) {

       Customer customer = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", id));
        return mapper.toDTO(customer);
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Optional<Customer> customer = repository.findByPhone(customerDTO.getPhone());
        if (customer.isPresent()) {
            throw new PhoneAlreadyExistsException("Customer", "Customer with phone " + customerDTO.getPhone() + " already exists.");
        }
        customerDTO.setRegistrationDate(LocalDate.now());
        Customer saved = repository.save(mapper.toEntity(customerDTO));
        return mapper.toDTO(saved);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDetails) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(customerDetails.getName());
                    existing.setPhone(customerDetails.getPhone());
                    existing.setEmail(customerDetails.getEmail());
                    existing.setAddress(customerDetails.getAddress());
                    if (customerDetails.getStatus() != null) {
                        existing.setStatus(customerDetails.getStatus());
                    }
                    return mapper.toDTO(repository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));

    }

    public void deleteCustomer(Long id) {
        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", id));
        repository.deleteById(id);
    }
}
