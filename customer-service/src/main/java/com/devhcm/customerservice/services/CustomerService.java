package com.devhcm.customerservice.services;

import com.devhcm.customerservice.dto.CustomerRequestDTO;
import com.devhcm.customerservice.dto.CustomerResponseDTO;
import java.util.List;

public interface CustomerService {
    CustomerResponseDTO getCustomer(String id);
    List<CustomerResponseDTO> listCustomers();
    CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(String id);
}
