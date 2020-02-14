package com.hss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hss.services.CachingExampleService;

@RestController
public class CachingExampleController {

	@Autowired
	private CachingExampleService cachingExampleService;
	
	
	@GetMapping("/hello/{name}")
	public String greet(@PathVariable String name) {
		return cachingExampleService.getWelcomeMessage(name);
	}
	
	@GetMapping("/bye/{name}")
	public String bye(@PathVariable String name) {
		return cachingExampleService.getByeMessage(name);
	}
	
}










