package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoBootMicroserviceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBootMicroserviceUserApplication.class, args);
		System.out.println("Project Running Sucessfully");
		System.out.println("http://localhost:8081/users");
	}

}
