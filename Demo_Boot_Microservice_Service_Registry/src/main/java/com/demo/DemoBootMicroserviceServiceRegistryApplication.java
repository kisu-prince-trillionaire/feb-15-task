package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoBootMicroserviceServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBootMicroserviceServiceRegistryApplication.class, args);
		System.out.println("Project Running Sucessfully");
		System.out.println("http://localhost:8080");
	}

}
