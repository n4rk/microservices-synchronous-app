package com.devhcm.billingservice;

import com.devhcm.billingservice.dto.InvoiceRequestDTO;
import com.devhcm.billingservice.entities.Customer;
import com.devhcm.billingservice.openfeign.CustomerRestClient;
import com.devhcm.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(InvoiceService invoiceService) {
		return args -> {
			invoiceService.saveInvoice(new InvoiceRequestDTO(BigDecimal.valueOf(Math.random() * 1000), "79de0b79-d6b7-45e7-b355-6015268eb90e"));
			invoiceService.saveInvoice(new InvoiceRequestDTO(BigDecimal.valueOf(Math.random() * 1000), "79de0b79-d6b7-45e7-b355-6015268eb90e"));
			invoiceService.saveInvoice(new InvoiceRequestDTO(BigDecimal.valueOf(Math.random() * 1000), "1c491bfa-8c29-4cfb-8731-681b107b3654"));
			invoiceService.saveInvoice(new InvoiceRequestDTO(BigDecimal.valueOf(Math.random() * 1000), "1c491bfa-8c29-4cfb-8731-681b107b3654"));
		};
	}

}
