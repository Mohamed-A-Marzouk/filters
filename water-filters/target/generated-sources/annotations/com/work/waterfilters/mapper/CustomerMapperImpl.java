package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.CustomerDTO;
import com.work.waterfilters.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-25T14:05:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerId( customer.getCustomerId() );
        customerDTO.setName( customer.getName() );
        customerDTO.setPhone( customer.getPhone() );
        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setAddress( customer.getAddress() );
        customerDTO.setRegistrationDate( customer.getRegistrationDate() );
        customerDTO.setStatus( customer.getStatus() );

        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( dto.getCustomerId() );
        customer.setName( dto.getName() );
        customer.setPhone( dto.getPhone() );
        customer.setEmail( dto.getEmail() );
        customer.setAddress( dto.getAddress() );
        customer.setRegistrationDate( dto.getRegistrationDate() );
        customer.setStatus( dto.getStatus() );

        return customer;
    }

    @Override
    public List<CustomerDTO> toDTOList(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( toDTO( customer ) );
        }

        return list;
    }
}
