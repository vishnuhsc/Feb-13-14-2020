package com.hss.lab01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // = @Controller + @ResponseBody
@RequestMapping("/calc")
public class CalcController {

	@Autowired
	private Calculator calculator;
	
	@PostMapping("/sum")
	public int sum(@RequestBody CalcParams params) {
		return calculator.add(params.getNum1(), params.getNum2());
	}
	
	@GetMapping("/divide/{a}/{b}")
	public MathResult divide(@PathVariable int a, @PathVariable int b) {
		int result = calculator.divide(a, b);
		MathResult mathResult = new MathResult();
		mathResult.setNum1(a);
		mathResult.setNum2(b);
		mathResult.setOperation("Division");
		mathResult.setResult(result);
		return mathResult;
	}
	

	@PutMapping("/subtract/{a}/{b}")
	public int subtract(@PathVariable int a, @PathVariable int b ) {
		return calculator.subtract(a, b);
	}
	
	@PostMapping("/product")
	public int product(@RequestParam int num1, @RequestParam int num2 ) {
		return calculator.multiply(num1, num2);
	}
	
	@GetMapping("/add/{a}/{b}")
	public int add(@PathVariable int a, @PathVariable int b ) {
		return calculator.add(a, b);
	}
	
	@GetMapping("/square/{a}")
	public int square(@PathVariable int a) {
		return calculator.square(a);
	}
	
}
