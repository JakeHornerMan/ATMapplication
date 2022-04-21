package com.jake.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int account_number;
	private int pin;
	private double balance;
	private double overdraft;
	
	public Account() {}
	
	public Account(int account_number, int pin, double balance, double overdraft) {
		super();
		//this.id = id;
		this.account_number = account_number;
		this.pin = pin;
		this.balance = balance;
		this.overdraft = overdraft;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	public String showAccount() {
		return "Account [account_number=" + account_number + ", balance=" + balance + ", overdraft="
				+ overdraft + "]";
	}
	
	public String showBalance() {
		return "Balance = " + balance + ", Overdraft = " + overdraft;
	}

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", pin=" + pin + ", balance=" + balance + ", overdraft="
				+ overdraft + "]";
	}
	
	
	
	
}
