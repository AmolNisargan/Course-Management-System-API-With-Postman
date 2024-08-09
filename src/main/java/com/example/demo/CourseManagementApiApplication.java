package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@EnableJpaRepositories(basePackages = "com.example.repository")

public class CourseManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementApiApplication.class, args);
	}

}
