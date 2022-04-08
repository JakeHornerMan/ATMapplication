package com.jake.factory;

import com.jake.controllers.AccountController;
import com.jake.dao.Serialization;
import com.jake.services.AccountService;
import com.jake.views.AtmView;

public class AtmFactory {
	
	public static AtmView getAtmView() {
		getSerialization().deserializeAccounts();
		return new AtmView(UtilFactory.getScanner(), getAccountController());
	}
	
	private static AccountController getAccountController() {
		return new AccountController(getAtmView(), getAccountService());
	}

	
	private static AccountService getAccountService() {
		return new AccountService(getSerialization(),getSerialization().deserializeAccounts());
	}

	private static Serialization getSerialization() {
		return new Serialization(UtilFactory.getAccountsList());
	}
}
