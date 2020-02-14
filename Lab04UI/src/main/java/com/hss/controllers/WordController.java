package com.hss.controllers;

import java.net.ConnectException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.hss.services.WordService;

@Controller
public class WordController {

	@Autowired
	private WordService wordService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/check")
	public String check(@RequestParam String word, HttpSession session) {
		String result = wordService.check(word);
		session.setAttribute("result", result);
		return "index";
	}
	
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<String> handleConnectException(ConnectException ex, WebRequest request) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.REQUEST_TIMEOUT);
	}
}
