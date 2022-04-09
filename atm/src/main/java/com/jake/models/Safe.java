package com.jake.models;

public class Safe {

	public int twoHundreds;
	public int hundreds;
	public int fiftys;
	public int twentys;
	public int tens;
	public int fives;
	
	public Safe(int twoHundreds, int hundreds, int fiftys, int twentys, int tens, int fives) {
		super();
		this.twoHundreds = twoHundreds;
		this.hundreds = hundreds;
		this.fiftys = fiftys;
		this.twentys = twentys;
		this.tens = tens;
		this.fives = fives;
	}

	public int getTwoHundreds() {
		return twoHundreds;
	}

	public void setTwoHundreds(int twoHundreds) {
		this.twoHundreds = twoHundreds;
	}

	public int getHundreds() {
		return hundreds;
	}

	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
	}

	public int getFiftys() {
		return fiftys;
	}

	public void setFiftys(int fiftys) {
		this.fiftys = fiftys;
	}

	public int getTwentys() {
		return twentys;
	}

	public void setTwentys(int twentys) {
		this.twentys = twentys;
	}

	public int getTens() {
		return tens;
	}

	public void setTens(int tens) {
		this.tens = tens;
	}

	public int getFives() {
		return fives;
	}

	public void setFives(int fives) {
		this.fives = fives;
	}

	@Override
	public String toString() {
		return "Safe [twoHundreds=" + twoHundreds + ", hundreds=" + hundreds + ", fiftys=" + fiftys + ", twentys="
				+ twentys + ", tens=" + tens + ", fives=" + fives + "]";
	}
	
	public String displayTotalSafe() {
		
		return "Safe holds = €"+ TotalInSafe();
	}
	
	public int TotalInSafe() {
		int ans = (twoHundreds*200) + (hundreds*100) + (fiftys*50) + (twentys*20) + (tens*10) + (fives*5);
		return ans;
	}
}
