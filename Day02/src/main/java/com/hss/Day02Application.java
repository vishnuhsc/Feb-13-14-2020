package com.hss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Day02Application {

	public static void main(String[] args) {
		SpringApplication.run(Day02Application.class, args);
	}

}
