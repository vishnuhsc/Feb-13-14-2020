package com.hss.controllers;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.hss.config.ErrorInformation;
import com.hss.services.AccountService;

@RestController
@RequestMapping("/bank")
@Validated
public class BankController {

	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/meta")
	public String getInfo() {
		String meta = "********************** <br/>";
		meta += " Class name: " + accountService.getClass().getName() + "<br/><br/>";
		meta += " Super Class name: " + accountService.getClass().getSuperclass().getName() + "<br/><br/>";
		meta += "<---INTERFACES --> <br/>";
		for(Class interfaceCls : accountService.getClass().getInterfaces()) {
			meta += interfaceCls.getName() + "<br/>";
		}
		meta += "<br/><---METHODS --> <br/>";
		for(Method method : accountService.getClass().getMethods()) {
			meta += method.getName() + "<br/>";
		}
		return meta;
	}
	

	@PostMapping("/deposit")
	public String deposit(@RequestParam("accountnumber") int accountNumber, 
			@RequestParam @Min(1) @Max(10000) int amount, 
			@RequestParam String type) {
		accountService.deposit(accountNumber, amount, type);
		return "Deposit successful";
	}

	@PostMapping("/withdraw")
	public String withdraw(@RequestParam("accountnumber") int accountNumber, @RequestParam int amount, @RequestParam String type) {
		accountService.withdraw(accountNumber, amount, type);
		return "Withdraw successful";
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInformation> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setMessage("ERROR: " + ex.getMessage());
		errorInformation.setTimestamp(LocalDateTime.now());
		errorInformation.setPath(request.getDescription(true));
		return new ResponseEntity<ErrorInformation>(errorInformation, HttpStatus.NOT_FOUND);
	}
	
	
	
}













