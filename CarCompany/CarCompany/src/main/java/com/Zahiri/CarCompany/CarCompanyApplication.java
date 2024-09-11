package com.Zahiri.CarCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CarCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarCompanyApplication.class, args);
	}

}
