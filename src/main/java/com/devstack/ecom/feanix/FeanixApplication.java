package com.devstack.ecom.feanix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeanixApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FeanixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// save all roles if not exists
		// save user (ADMIN)-> if not exists
	}
}
