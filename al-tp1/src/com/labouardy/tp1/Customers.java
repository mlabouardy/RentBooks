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

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> it=_rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while(it.hasNext()){
			Rental r=it.next();
			double thisAmount=r.calcAllAmount();
			frequentRenterPoints+=r.getRentalPoints();
			result += "\t" + r.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + " \n";
			totalAmount += thisAmount;
		}
		result += "Amount owned is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}
	
	

	

	
}
