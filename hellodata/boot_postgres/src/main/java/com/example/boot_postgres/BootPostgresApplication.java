package com.example.boot_postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BootPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootPostgresApplication.class, args);
	}
}
