package com.jake.factory;

import com.jake.controllers.AccountController;
import com.jake.controllers.RestApiController;
import com.jake.controllers.SafeController;
import com.jake.dao.Serialization;
import com.jake.services.AccountService;
import com.jake.services.SafeService;
import com.jake.views.AtmView;

public class AtmFactory {
	
	public static AtmView getAtmView() {
		setRestApiController();
		return new AtmView(UtilFactory.getScanner(), getAccountController(), getSafeController());
	}
	

	private static RestApiController setRestApiController() {
		return new RestApiController(getAccountService(), getSafeService());
	}


	private static SafeController getSafeController() {
		return new SafeController(getSafeService());
	}

	private static SafeService getSafeService() {
		return new SafeService();
	}

	private static AccountController getAccountController() {
		return new AccountController(getAccountService());
	}

	
	private static AccountService getAccountService() {
		return new AccountService(UtilFactory.getAccountsList());
	}

	
}
