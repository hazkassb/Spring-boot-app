package com.hazkassb.zgigi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ZGigiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZGigiApplication.class, args);
	}

}
