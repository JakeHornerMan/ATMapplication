package com.jake.controllers;

import org.springframework.web.bind.annotation.GetMapping;
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
		
	@GetMapping("/accountDetails")
	public String accountDetails(@RequestParam(value = "accNum", defaultValue = "0") int accNum) {
		
		return accountService.ApiShowBalance(accNum);
		
		//return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	
	
}
