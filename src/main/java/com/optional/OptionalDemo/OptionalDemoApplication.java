package com.optional.OptionalDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
public class OptionalDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptionalDemoApplication.class, args);
		System.out.println("Starts from here");
	}

}
