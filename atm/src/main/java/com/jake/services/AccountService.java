package com.jake.services;

import java.util.List;

import com.jake.dao.Serialization;
import com.jake.models.Account;

public class AccountService {

	private Account signedInAccount = null;
	private Account account1= new Account(123456789,1234,800,200);
	private Account account2= new Account(987654321,4321,1230,150);
	private List<Account> accounts;

	
	public AccountService(List<Account> accounts) {
		this.accounts = accounts;
		accounts.add(account1);
		accounts.add(account2);
		
	}
	

	public void createAccount(int accNum, int pin, double balance, double overdraft) {
		Account newAccount = new Account(accNum, pin, balance,overdraft);
		accounts.add(newAccount);
	}


	public boolean ExistingAccount(int ans) {
		accounts.add(account1);
		accounts.add(account2);
		for (Account account : accounts) {
			if(ans == account.getAccount_number()) {
				signedInAccount = account;
				return true;
			}
		}
		return false;
	}


	public boolean PinforAccount(int ans) {
		
		if(ans == signedInAccount.getPin()) {
			return true;
		}
		else {
			signedInAccount = null;
			return false;
		}
	}


	public boolean IsThereAccountFunds(int ans) {
		if(ans <= signedInAccount.getBalance()) {
			return true;
		}
		else {
			return false;
		} 
	}

}