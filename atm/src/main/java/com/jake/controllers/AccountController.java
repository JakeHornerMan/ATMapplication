package com.jake.controllers;

import com.jake.services.AccountService;
import com.jake.views.AtmView;

public class AccountController {

	private AtmView view;
	private AccountService accountService;
	
	public AccountController(AtmView view, AccountService accountService) {
		this.view = view;
		this.accountService = accountService;
	}

	public void addAccount(int accNum, int pin, double balance, double overdraft) {
		if(String.valueOf(accNum).length() != 9) {
			view.invalidInput();
		}		
		else if(String.valueOf(pin).length() != 4) {
			view.invalidInput();
		}
		else {
			accountService.createAccount(accNum, pin, balance,overdraft);
		}
	}

}
