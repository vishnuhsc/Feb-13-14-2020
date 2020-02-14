package com.hss.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CachingExampleService {

	//{name: "Sam", "message": "Hello Sam"}
	//{name: "John", "message": "Hello John"}
	@Cacheable(value = "message", key = "#name")
	public String getWelcomeMessage(String name) {
		System.out.println("********** Computing message for " + name);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello " + name;
	}
	
	@CacheEvict(key = "#name", value = "message")
	public String getByeMessage(String name) {
		return "Bye Bye " + name;
	}
	
	
}




