package com.hss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	
	//http://localhost:8080/register?name=Sam
	
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestParam("name") String name) {
		return name + "! Registration successful";
	}
	
	
	//http://localhost:8080/bye/Sam
	@PostMapping("/bye/{name}")
	@ResponseBody
	public String bye(@PathVariable("name") String name) {
		return "Bye Bye " + name;
	}
	
	//http://localhost:8080/greet
	
	@GetMapping("/greet")
	@ResponseBody
	public String greet() {
		return "Wassup";
	}
	
}
