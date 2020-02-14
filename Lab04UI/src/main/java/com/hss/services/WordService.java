package com.hss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WordService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${palindrome.base.url}")
	private String palindromeBaseUrl;
	
	@Cacheable(value = "palindrome", key = "#word")
	public String check(String word) {
		String url = palindromeBaseUrl + "/" + word;
		ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
		if(response.getBody()) {
			return word + " is a palindrome";
		}
		return word + " is not a palindrome";
	}
}
