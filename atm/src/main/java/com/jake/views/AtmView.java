package com.jake.views;

import java.util.Scanner;

import com.jake.controllers.AccountController;


public class AtmView {

	private Scanner sc;
	private AccountController accountController;

	public AtmView(Scanner sc, AccountController accountController) {
		this.sc = sc;
		this.accountController = accountController;
	}
	

	public void startMenu() {
		System.out.println("Main Menu");
		System.out.println("1. Account Access");
		System.out.println("2. Dev Options");
		System.out.println("-------------------------------------------------");
		int ans = sc.nextInt();
		
		switch (ans) {
		case 1:
			accountAccess();
			break;
		case 2:
			devOptions();
			break;
		default:
			System.out.println("PLEASE SELECT A NUMBER OPTION");
			startMenu();
		}
	}
	
	private void accountAccess() {
		System.out.println("Please Enter your Account Number: ");
	}
	
	public void devOptions() {
		System.out.println("Dev Menu");
		System.out.println("1. Create Account");
		System.out.println("2. Edit Safe Amounts");
		System.out.println("-------------------------------------------------");
		int ans = sc.nextInt();
		
		switch (ans) {
		case 1:
			createAccountMenu();
			break;
		case 2:
			devOptions();
			break;
		default:
			System.out.println("PLEASE SELECT A NUMBER OPTION");
			startMenu();
		}
	}


	private void createAccountMenu() {
		System.out.println("Please Enter a 9 digit Account Number: ");
		int accNum = sc.nextInt();
		System.out.println("Please Enter a 4 digit pin");
		int pin = sc.nextInt();
		System.out.println("Please Enter a account Balance");
		double balance = sc.nextDouble();
		System.out.println("Please Enter a account overdraft");
		double overdraft = sc.nextDouble();
		
		accountController.addAccount(accNum,pin,balance,overdraft);
	}


	public void invalidInput() {
		System.out.println("You have entered an invalid input");
		System.out.println("Returning to Main Menu");
		System.out.println("-------------------------------------------------");
		startMenu();
	}
	
}
