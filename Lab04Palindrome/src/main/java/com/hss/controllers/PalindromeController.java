package com.hss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hss.services.PalindromeService;

@RestController
public class PalindromeController {

	@Autowired
	private PalindromeService palindromeService;
	
	@GetMapping("/palindrome/{word}")
	public boolean checkPalindrome(@PathVariable String word) {
		return palindromeService.isPalindrome(word);
	}
}
