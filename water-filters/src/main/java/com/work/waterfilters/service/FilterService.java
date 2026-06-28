package com.work.waterfilters.service;

import com.work.waterfilters.dto.FilterRequest;
import com.work.waterfilters.entity.Customer;
import com.work.waterfilters.entity.Filter;
import com.work.waterfilters.entity.FilterModels;
import com.work.waterfilters.exception.PhoneAlreadyExistsException;
import com.work.waterfilters.exception.ResourceNotFoundException;
import com.work.waterfilters.mapper.FilterMapper;
import com.work.waterfilters.repository.CustomerRepository;
import com.work.waterfilters.repository.FilterModelRepository;
import com.work.waterfilters.repository.FilterRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FilterService {
    private final FilterRepository repository;
    private final CustomerRepository customerRepository;
    private final FilterModelRepository filterModelRepository;
    public List<FilterRequest> getAllFilters() {
        return FilterMapper.toDTOList(repository.findAll());
    }

    public List<FilterRequest> getCustomerFilters(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", customerId+""));

        return FilterMapper.toDTOList(repository.findByCustomer_CustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Filters for Customer", "customerId", customerId+"")));
    }

    public FilterRequest getFilterById(Long id) {
        Filter filter = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Filter ", "id", id+""));
        return FilterMapper.toDto(filter);
    }

    public FilterRequest getFilterBySerialNum(String serialNumber) {
        Filter filter = repository.findBySerialNum(serialNumber).orElseThrow(
                () -> new ResourceNotFoundException("Filter ", "Serial number", serialNumber));
        return FilterMapper.toDto(filter);
    }

    public FilterRequest createFilter(@Valid FilterRequest filterRequest) {
        Optional<Filter> filter = repository.findBySerialNum(filterRequest.getSerialNum());
        if (filter.isPresent()) {
            throw new PhoneAlreadyExistsException("Filter", "Filter with Serial Number " + filterRequest.getSerialNum() + " already exists.");
        }

        Customer customer = customerRepository.findById(filterRequest.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", filterRequest.getCustomerId()+""));

        FilterModels filterModel = filterModelRepository.findById(filterRequest.getModelId()).orElseThrow(
                () -> new ResourceNotFoundException("Filter Model", "id", filterRequest.getModelId()+""));

        filter = Optional.ofNullable(FilterMapper.toEntity(filterRequest));

        filter.ifPresent(f -> {
            f.setCustomer(customer);
            f.setModel(filterModel);
            f.setLocation((filterRequest.getLocation() == null || filterRequest.getLocation().isEmpty()) ?
                    customer.getAddress() : filterRequest.getLocation());
            f.addPhases(filterModel.getPhases());
        });

        Filter saved = repository.save(filter.orElseThrow(() -> new RuntimeException("Failed to create filter")));
        filterModel.setQuantity(filterModel.getQuantity() - 1);
        filterModelRepository.save(filterModel);

        return FilterMapper.toDto(saved);
    }
}
