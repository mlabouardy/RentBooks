package com.labouardy.tp1;

public class Rental {
	private final double AMOUNT_REGULAR=2;
	private final double AMOUNT_CHILDRENS=1.5;
	private final double AMOUNT_NEW_RELEASE=0;
	
	private final int REGULAR_FLAT_RATE=2;
	private final int NEW_RELEASE_FLAT_RATE=0;
	private final int CHILDREN_FLAT_RATE=3;
	
	private final double REGULAR_OUT_RATE=1.5;
	private final double NEW_RELEASE_OUT_RATE=3;
	private final double CHILDREN_OUT_RATE=1.5;
	
	
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
	
	public int getRentalPoints() {
		int frequentRenterPoints = 0;
		frequentRenterPoints++;
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
				&& (getDaysRented() > 1))
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
	
	public double calcAllAmount(){
		double amount=0;
		switch(getMovie().getPriceCode()){
			case Movie.REGULAR:
				amount=calcAmount(getDaysRented(), AMOUNT_REGULAR, REGULAR_FLAT_RATE ,REGULAR_OUT_RATE);
				break;
			case Movie.NEW_RELEASE:
				amount=calcAmount(getDaysRented(), AMOUNT_NEW_RELEASE, NEW_RELEASE_FLAT_RATE ,NEW_RELEASE_OUT_RATE);
				break;
			case Movie.CHILDRENS:
				amount=calcAmount(getDaysRented(), AMOUNT_CHILDRENS, CHILDREN_FLAT_RATE ,CHILDREN_OUT_RATE);
		}
		return amount;
	}
	
	private double calcAmount(int nbrOfDays, double fixedPrice, double flatRate, double outRate){
		double amount=0;
		amount+=fixedPrice;
		if(nbrOfDays>flatRate){
			amount += computeAmount(nbrOfDays, flatRate, outRate);
		}
		return amount;
	}
	
	public double computeAmount(int nbrOfDays, double flatRate, double outRate){
		return (nbrOfDays - flatRate) * outRate;
	}
}
