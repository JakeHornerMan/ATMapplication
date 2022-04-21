package com.jake.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Safe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public int fiftys;
	public int twentys;
	public int tens;
	public int fives;
	
	public Safe() {}
	
	public Safe(int id, int fiftys, int twentys, int tens, int fives) {
		super();
		this.fiftys = fiftys;
		this.twentys = twentys;
		this.tens = tens;
		this.fives = fives;
		System.out.println("Safe created!");
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Safe [fiftys=" + fiftys + ", twentys="
				+ twentys + ", tens=" + tens + ", fives=" + fives + "]";
	}
	
	public String displayTotalSafe() {
		
		return "Safe holds = €"+ TotalInSafe();
	}
	
	public int TotalInSafe() {
		int ans = (fiftys*50) + (twentys*20) + (tens*10) + (fives*5);
		return ans;
	}
}
