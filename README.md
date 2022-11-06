# Microservices - gestion des clients et factures

TP : Application distribuée basée sur deux micro-services (Customer et Billing) en utilisant
Spring framework, OpenFeign, Eureka discovery, Gateway.


### Customer-service :
![customer-service](https://user-images.githubusercontent.com/62244067/200178843-3fc7ee91-a1f5-4d63-8d58-3d7e66335421.jpg)

- Main
```java
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
```
![customer-service2](https://user-images.githubusercontent.com/62244067/200178865-1e3b5798-9ee9-45e5-b20c-50d2fdd6e9de.jpg)



### Billing-service :
![billing-service](https://user-images.githubusercontent.com/62244067/200178873-d91df107-7217-45c6-aa11-b3e2093907b4.jpg)

- OpenFeign
```java
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/api/customers/{id}")
    Customer getCustomer(@PathVariable String id);
    @GetMapping(path = "/api/customers")
    List<Customer> allCustomers();
}
```
- Main
```java
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
```
![billing-service2](https://user-images.githubusercontent.com/62244067/200178882-209ff0b5-0345-4bde-a4d8-fd0565624338.jpg)




### Eureka-service :
![eureka1](https://user-images.githubusercontent.com/62244067/200179017-1bd3ded5-8054-45f8-bc33-54a3468716bf.jpg)

![eureka2](https://user-images.githubusercontent.com/62244067/200179041-c2c471e1-e67e-4003-8eaf-4b61a4bd3088.jpg)




### Gateway :
![gateway1](https://user-images.githubusercontent.com/62244067/200179088-6913c5ba-bb45-43be-babd-607c68ab3853.jpg)


```java
@Configuration
public class GatewayConfig {
    @Bean
    DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
            ReactiveDiscoveryClient rdc,
            DiscoveryLocatorProperties dlp
    ) {
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }
}
```

The gateway now allows the 2 micro-services to communicate with each other through port : 9999
