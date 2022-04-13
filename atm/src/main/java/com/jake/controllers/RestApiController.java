package com.jake.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jake.services.AccountService;
import com.jake.services.SafeService;


@RestController
public class RestApiController {
	
	private AccountService accountService; 
	private SafeService safeService;
	
	public RestApiController(AccountService accountService, SafeService safeService) {
		this.accountService = accountService;
		this.safeService = safeService;
	}
	
	@GetMapping(value = "/")
	public String welcome() {
		return "welcome to atm";
	}
	
	@RequestMapping(path = "/atm/safe", method = RequestMethod.GET)
	public String showsafe() {
		return safeService.ApiDisplaySafe();
	}
	
	@RequestMapping(path = "/atm/{accountNumber}/{pin}", method = RequestMethod.GET)
	public String signin(@PathVariable int accountNumber, @PathVariable int pin) {
		return accountService.ApiSignIn(accountNumber,pin);
	}
	
	@RequestMapping(path = "/atm/{accountNumber}/{pin}/balance", method = RequestMethod.GET)
	public String accountDetails(@PathVariable int accountNumber, @PathVariable int pin) {
		return accountService.ApiShowBalance(accountNumber, pin);
	}
	
	@RequestMapping(path = "/atm/{accountNumber}/{pin}/withdraw/{withdraw}", method = RequestMethod.GET)
	public String withdraw(@PathVariable int accountNumber, @PathVariable int pin, @PathVariable int withdraw) {
		
		if(accountService.ApiIsThereAccountFunds(accountNumber,pin,withdraw) == true) {
			if(safeService.IsThereSufficiantFundsInSafe(withdraw)) {
				accountService.ApiWithdraw(accountNumber,pin,withdraw);
				String ans= safeService.calulateNotes(withdraw);
				return ans + " Totaling: " + withdraw;
			}
			else {
				return "there is no sufficiant funds in safe";
			}
		}
		else {
			return "no avaliable funds in account"; 
		}
	}
	
}
