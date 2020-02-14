package com.hss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Lab04UiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab04UiApplication.class, args);
	}

}
