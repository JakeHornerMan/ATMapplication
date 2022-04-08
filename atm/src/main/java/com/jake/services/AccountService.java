package com.jake.services;

import java.util.List;

import com.jake.dao.Serialization;
import com.jake.models.Account;

public class AccountService {

	private Account account = null;
	private Serialization serialization;
	private List<Account> accounts;
	
	public AccountService(Serialization serialization, List<Account> accounts) {
		this.serialization = serialization;
		this.accounts = accounts;
	}
	

	public void createAccount(int accNum, int pin, double balance, double overdraft) {
		Account newAccount = new Account(accNum, pin, balance,overdraft);
		accounts.add(newAccount);
		serialization.serializeAccounts(accounts);
	}

}
