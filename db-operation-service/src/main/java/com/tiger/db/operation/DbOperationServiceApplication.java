package com.tiger.db.operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DbOperationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbOperationServiceApplication.class, args);
	}

}
