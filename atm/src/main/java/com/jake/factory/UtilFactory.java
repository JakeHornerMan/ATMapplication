package com.jake.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jake.models.Account;


public class UtilFactory {
	public static Scanner getScanner() {
		return new Scanner(System.in);
	}

	public static List<Account> getAccountsList() {
		// TODO Auto-generated method stub
		return new ArrayList<Account>();
	}
}
