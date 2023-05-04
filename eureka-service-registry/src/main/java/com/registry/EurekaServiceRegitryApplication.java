package com.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceRegitryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceRegitryApplication.class, args);
	}

}
