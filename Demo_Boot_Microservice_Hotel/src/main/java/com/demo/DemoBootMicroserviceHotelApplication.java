package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoBootMicroserviceHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBootMicroserviceHotelApplication.class, args);
		System.out.println("Project Running Sucessfully");
		System.out.println("http://localhost:8082/hotels");
	}

}
