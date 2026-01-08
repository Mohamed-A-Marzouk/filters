package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.CustomerDTO;
import com.work.waterfilters.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO dto);

    List<CustomerDTO> toDTOList(List<Customer> customers);
}