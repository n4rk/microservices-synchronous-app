package com.devhcm.customerservice.mappers;

import com.devhcm.customerservice.dto.CustomerRequestDTO;
import com.devhcm.customerservice.dto.CustomerResponseDTO;
import com.devhcm.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer CustomerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
