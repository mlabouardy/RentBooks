package com.labouardy.tp1;

import java.util.*;

public class Customers {
	
	private String name;
	private Vector<Rental> _rentals;
    
	
	public Customers(String name) {
		this.name = name;
		this._rentals=new Vector<Rental>();
	}

	public void addRental(Rental rental) {
		_rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public double getTotalAmount(){
		double s=0;
		for(Rental r:_rentals){
			s+=r.calcAllAmount();
		}
		return s;
	}
	
	public int getTotalRentalPoints(){
		int s=0;
		for(Rental r:_rentals){
			s+=r.getRentalPoints();
		}
		return s;
	}
	
	
	public String statement() {
		String result = "Rental Record for " + getName() + "\n";
		for(Rental currentRental: _rentals){
			result += "\t" + currentRental.getMovie().getTitle() + "\t" + String.valueOf(currentRental.getRentalPoints()) + " \n";
		}
		result += "Amount owned is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalRentalPoints()) + " frequent renter points";
		return result;
	}
	
	public String statement(Builder b) {
		b.startDocument();
		b.addText("Rental Record for " + getName());
		b.newLine();
		for(Rental currentRental: _rentals){
			b.addText("\t" + currentRental.getMovie().getTitle() + "\t" + String.valueOf(currentRental.getRentalPoints()));
			b.newLine();
		}
		b.addText("Amount owned is " + String.valueOf(getTotalAmount()));
		b.newLine();
		b.addText("You earned " + String.valueOf(getTotalRentalPoints()) + " frequent renter points");
		b.newLine();
		b.endDocument();
		return b.getContent();
	}
	
	
}
