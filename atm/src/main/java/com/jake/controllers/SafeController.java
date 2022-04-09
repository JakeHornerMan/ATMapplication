package com.jake.controllers;

import com.jake.services.SafeService;

public class SafeController {
	
	private SafeService safeService;

	public SafeController(SafeService safeService) {
		this.safeService = safeService;
	}

	public void accessSafe() {
		safeService.displaySafe();
	}

	public boolean checkSafe(int ans) {
		return safeService.IsThereSufficiantFundsInSafe(ans);
	}
	
}
