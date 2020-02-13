package com.hss;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreLunchController {

	@Autowired
	private Car car;
	
	@Autowired
	private List<String> southIndianMenuItems;
	
	@GetMapping("/menu")
	public List<String> getMenu() {
		return southIndianMenuItems;
	}
	
	
}
