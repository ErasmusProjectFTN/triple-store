package com.ErasmusProject.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ErasmusProject.app","com.ErasmusProject.rest"})
public class TripleStoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripleStoreServiceApplication.class, args);
	}
}
