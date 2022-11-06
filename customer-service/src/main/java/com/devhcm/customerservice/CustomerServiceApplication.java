package com.devhcm.customerservice;

import com.devhcm.customerservice.dto.CustomerRequestDTO;
import com.devhcm.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService) {
		return args -> {
			customerService.saveCustomer(new CustomerRequestDTO(UUID.randomUUID().toString(), "Amine", "amine@devhcm.com"));
			customerService.saveCustomer(new CustomerRequestDTO(UUID.randomUUID().toString(), "Hamza", "hamza@test.com"));
			customerService.saveCustomer(new CustomerRequestDTO(UUID.randomUUID().toString(), "Houssine", "houssine@test.com"));
		};
	}
}
