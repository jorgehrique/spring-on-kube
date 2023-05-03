package com.springonkube.fraseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
public class FraseServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FraseServiceApplication.class, args);
	}

}
