package com.innovation.biometric;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

class BiometricApplication {
	public static void main(String[] args) {
		SpringApplication.run(BiometricApplication.class, args);
	}
	@RequestMapping("/")
	public String hello () {
		return "hello world";
	}

}


//	@Test
//	void contextLoads() {
//	}


