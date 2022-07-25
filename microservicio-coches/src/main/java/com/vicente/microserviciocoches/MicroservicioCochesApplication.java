package com.vicente.microserviciocoches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioCochesApplication {

	public static void main(String[] args) {
		SpringApplication.run(
			MicroservicioCochesApplication.class, args);
	}

}
