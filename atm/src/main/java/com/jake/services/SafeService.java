package com.jake.services;

import com.jake.models.Safe;

public class SafeService {
	
	private Safe atmSafe = new Safe(0,0,10,30,30,20);  
	
	public SafeService() {
		
	}

	public void displaySafe() {
		System.out.println(atmSafe.toString());
		System.out.println(atmSafe.displayTotalSafe());	
	}

	public boolean IsThereSufficiantFundsInSafe(int ans) {
		if(ans <= atmSafe.TotalInSafe()) {
			return true;
		}
		else {
			return false;
		}
	}

}
