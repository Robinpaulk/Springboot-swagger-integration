package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeeProjectsSystem2Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectsSystem2Application.class, args);
	}

}
