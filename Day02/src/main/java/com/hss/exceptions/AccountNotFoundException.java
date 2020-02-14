package com.hss.exceptions;

public class AccountNotFoundException extends RuntimeException  {

	public AccountNotFoundException(int accountNumber) {
		super("Account " + accountNumber + " not found");
	}

}
