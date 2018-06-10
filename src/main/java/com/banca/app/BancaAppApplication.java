package com.banca.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="com.banca.app.entity") //señala donde estan las entidades
public class BancaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancaAppApplication.class, args);
	}
}
