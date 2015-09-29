package com.labouardy.tp1;

import java.util.*;

public class Customers {
	private final double AMOUNT_REGULAR=2;
	private final double AMOUNT_CHILDRENS=1.5;
	private final int REGULAR_FLAT_RATE=2;
	private final int NEW_RELEASE_FLAT_RATE=0;
	private final int CHILDREN_FLAT_RATE=3;
	private final double REGULAR_OUT_RATE=1.5;
	private final double NEW_RELEASE_OUT_RATE=3;
	private final double CHILDREN_OUT_RATE=1.5;
	
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
			double thisAmount=calcMoviesAmount(r);
			frequentRenterPoints=calcRenterPoints(r, frequentRenterPoints);
			result += "\t" + r.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + " \n";
			totalAmount += thisAmount;
		}
		result += "Amount owned is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}
	
	private double calcMoviesAmount(Rental r){
		double amount=0;
		switch(r.getMovie().getPriceCode()){
			case Movie.REGULAR:
				amount += AMOUNT_REGULAR;
				if (r.getDaysRented() > REGULAR_FLAT_RATE) {
					amount +=calcAmount(r.getDaysRented(), REGULAR_FLAT_RATE ,REGULAR_OUT_RATE);
				}
				break;
			case Movie.NEW_RELEASE:
				amount +=calcAmount(r.getDaysRented(), NEW_RELEASE_FLAT_RATE ,NEW_RELEASE_OUT_RATE);
				break;
			case Movie.CHILDRENS:
				amount += AMOUNT_CHILDRENS;
				if (r.getDaysRented() > CHILDREN_FLAT_RATE)
					amount +=calcAmount(r.getDaysRented(), CHILDREN_FLAT_RATE ,CHILDREN_OUT_RATE);
		}
		return amount;
	}

	private double calcAmount(int nbrOfDays, int flatRate, double outRate){
		return (nbrOfDays - flatRate) * outRate;
	}
	
	private int calcRenterPoints(Rental r, int frequentRenterPoints){
		frequentRenterPoints++;
		if ((r.getMovie().getPriceCode() == Movie.NEW_RELEASE) && (r.getDaysRented() > 1))
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
}
