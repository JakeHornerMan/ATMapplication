package com.jake.views;

import java.util.Scanner;

import com.jake.controllers.AccountController;
import com.jake.controllers.SafeController;


public class AtmView {

	private Scanner sc;
	private AccountController accountController;
	private SafeController safeController;

	public AtmView(Scanner sc, AccountController accountController,SafeController safeController) {
		this.sc = sc;
		this.accountController = accountController;
		this.safeController = safeController;
	}
	

	public void startMenu() {
		System.out.println("Main Menu");
		System.out.println("1. Account Access");
		System.out.println("2. Dev Options");
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
		System.out.println("-------------------------------------------------");
		System.out.println("Please Enter your Account Number: ");
		int ans = sc.nextInt();
		if(accountController.isThereAccount(ans)) {
			System.out.println("Please Enter your Account PIN: ");
			ans = sc.nextInt();
			if(accountController.isPinCorrect(ans)) {
				AccountMenu();
			}
			else {
				invalidInput();
			}
		}
		else {
			invalidInput();
		}
	}
	
	private void AccountMenu() {
		System.out.println("-------------------------------------------------");
		System.out.println("Account Menu");
		System.out.println("1. Withdraw");
//		System.out.println("2. Deposit");
		System.out.println("3. View Account Details");
		System.out.println("123. Sign out of Account");
		int ans = sc.nextInt();
		
		switch (ans) {
		case 1:
			WithdrawMenu();
			break;
//		case 2:
//			DepositMenu();
//			break;
		case 3:
			System.out.println(accountController.getAccount());
			AccountMenu();
			break;
		case 123:
			accountController.signOut();
			startMenu();
			break;
		default:
			System.out.println("PLEASE SELECT A NUMBER OPTION");
			AccountMenu();
		}
	}


	private void WithdrawMenu() {
		System.out.println("-------------------------------------------------");
		System.out.println("Please enter a number to withdraw (only in nominations of 5 this machine does not have coins)");
		int ans = sc.nextInt();
		if(ans % 5 == 0 && ans > 0 ) {
			if(accountController.checkFunds(ans)) {
				if(safeController.checkSafe(ans)) {
					Withdrawing(ans);
				}
				else {
					System.out.println("Apologies, the ATM Safe doesnt hold sufficient funds!");
					System.out.println("Please try again!");
					WithdrawMenu();
				}
			}
			else {
				System.out.println("Your Account does not have sufficient Funds");
				System.out.println("Please try again!");
				WithdrawMenu();
			}
		}
		else {
			System.out.println("You didnt enter a number divided by 5, or have enetered a 0");
			System.out.println("Please try again!");
			AccountMenu();
		}
	}


	private void Withdrawing(int ans) {
		String notes = safeController.getNotes(ans);
		accountController.takeAwayWithdrawal(ans);
		System.out.println("Now dispencing: "+ ans);
		System.out.println(notes);
		System.out.println("You have "+accountController.getBalance()+" left.");
		AccountMenu();
	}


	public void devOptions() {
		System.out.println("Dev Menu");
//		System.out.println("1. Create Account");
		System.out.println("2. View Safe Amounts");
//		System.out.println("3. Edit Safe Amounts");
		
		System.out.println("123. Back to Main Menu");
		System.out.println("-------------------------------------------------");
		int ans = sc.nextInt();
		
		switch (ans) {
//		case 1:
//			createAccountMenu();
//			break;
		case 2:
			viewSafe();
			break;
//		case 3:
//			devOptions();
//			break;
		case 123:
			startMenu();
			break;
		default:
			System.out.println("PLEASE SELECT A NUMBER OPTION");
			devOptions();
		}
	}


	private void viewSafe() {
		safeController.accessSafe();
		devOptions();
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
		
		if(String.valueOf(accNum).length() != 9) {
			invalidInput();
		}		
		else if(String.valueOf(pin).length() != 4) {
			invalidInput();
		}
		else {
			accountController.addAccount(accNum,pin,balance,overdraft);
			startMenu();
		}
	}


	public void invalidInput() {
		System.out.println("You have entered an invalid input");
		System.out.println("Returning to Main Menu");
		System.out.println("-------------------------------------------------");
		startMenu();
	}
	
}
