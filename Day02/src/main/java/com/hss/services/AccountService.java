package com.hss.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hss.entities.Account;
import com.hss.entities.Statement;
import com.hss.repositories.AccountRepository;
import com.hss.repositories.StatementRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private StatementRepository statementRepository;


	//@Transactional
	public void deposit(int accountNumber,int amount, String type) {
		Optional<Account> optAccount = accountRepository.findById(accountNumber);
		if(optAccount.isPresent()) {
			Account account = optAccount.get();
			account.setBalance(account.getBalance() + amount);

			createStatement(amount, type, account);
		}
	}

	@Transactional
	public void withdraw(int accountNumber,int amount, String type) {
		Optional<Account> optAccount = accountRepository.findById(accountNumber);
		if(optAccount.isPresent()) {
			Account account = optAccount.get();
			account.setBalance(account.getBalance() - amount);
			//ONLY FOR DEMO PURPOSE
			accountRepository.save(account);
			createStatement(amount, type, account);
		}
	}

	private void createStatement(int amount, String type, Account account) {
		Statement statement = new Statement();
		statement.setAccount(account);
		statement.setAmount(amount);
		statement.setType(type);
		statementRepository.save(statement);
	}

}





