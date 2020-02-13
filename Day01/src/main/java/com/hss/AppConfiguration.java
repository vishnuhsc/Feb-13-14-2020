package com.hss;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	//<bean id="car" class="com.hss.Car"/>
	@Bean
	public Car car() {
		return new Car();
	}
	
	@Bean
	public List<String> southIndianMenuItems() {
		return Arrays.asList("Rasam", "Sambhar", "Biriyani");
	}
	
	@Bean
	public List<String> menuItems() {
		return Arrays.asList("Rice", "Roti", "Dessert", "Snacks");
	}
	
}
