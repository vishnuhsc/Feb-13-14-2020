package com.hss.services;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

	public boolean isPalindrome(String word) {
		String reversedWord = new StringBuilder(word).reverse().toString();
		return word.equalsIgnoreCase(reversedWord);
	}
}
