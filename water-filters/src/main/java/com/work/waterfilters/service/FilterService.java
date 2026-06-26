package com.work.waterfilters.service;

import com.work.waterfilters.dto.FilterDto;
import com.work.waterfilters.dto.FilterModelDTO;
import com.work.waterfilters.entity.Customer;
import com.work.waterfilters.entity.Filter;
import com.work.waterfilters.entity.FilterModels;
import com.work.waterfilters.exception.PhoneAlreadyExistsException;
import com.work.waterfilters.exception.ResourceNotFoundException;
import com.work.waterfilters.mapper.FilterMapper;
import com.work.waterfilters.mapper.FilterModelMapper;
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
    public List<FilterDto> getAllFilters() {
        return FilterMapper.toDTOList(repository.findAll());
    }

    public FilterDto getFilterById(Long id) {
        Filter filter = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Filter ", "id", id+""));
        return FilterMapper.toDto(filter);
    }

    public FilterDto getFilterBySerialNum(String serialNumber) {
        Filter filter = repository.findBySerialNum(serialNumber).orElseThrow(
                () -> new ResourceNotFoundException("Filter ", "Serial number", serialNumber));
        return FilterMapper.toDto(filter);
    }

    public FilterDto createFilter(@Valid FilterDto filterDto) {
        Optional<Filter> filter = repository.findBySerialNum(filterDto.getSerialNum());
        if (filter.isPresent()) {
            throw new PhoneAlreadyExistsException("Filter", "Filter with Serial Number " + filterDto.getSerialNum() + " already exists.");
        }

        Customer customer = customerRepository.findById(filterDto.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", filterDto.getCustomerId()+""));

        FilterModels filterModel = filterModelRepository.findById(filterDto.getModelId()).orElseThrow(
                () -> new ResourceNotFoundException("Filter Model", "id", filterDto.getModelId()+""));

        filter = Optional.ofNullable(FilterMapper.toEntity(filterDto));

        filter.ifPresent(f -> {
            f.setCustomer(customer);
            f.setModel(filterModel);
            f.setLocation((filterDto.getLocation() == null || filterDto.getLocation().isEmpty()) ?
                    customer.getAddress() : filterDto.getLocation());
            f.addPhases(filterModel.getPhases());
        });

        Filter saved = repository.save(filter.orElseThrow(() -> new RuntimeException("Failed to create filter")));
        filterModel.setQuantity(filterModel.getQuantity() - 1);
        filterModelRepository.save(filterModel);

        return FilterMapper.toDto(saved);
    }
}
