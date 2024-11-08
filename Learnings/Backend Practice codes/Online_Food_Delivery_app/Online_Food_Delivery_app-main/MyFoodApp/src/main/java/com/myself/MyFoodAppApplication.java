package com.myself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyFoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFoodAppApplication.class, args);
	}

	// Readme file
	//https://github.com/ImErPratik/Online_Food_Delivery_app
}
