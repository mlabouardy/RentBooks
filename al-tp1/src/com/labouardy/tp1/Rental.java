package com.labouardy.tp1;

public class Rental {
	public static final double AMOUNT_REGULAR = 2;
	public static final double AMOUNT_CHILDRENS = 1.5;
	public static final double AMOUNT_NEW_RELEASE = 0;

	public static final int REGULAR_FLAT_RATE = 2;
	public static final int NEW_RELEASE_FLAT_RATE = 0;
	public static final int CHILDREN_FLAT_RATE = 3;

	public static final double REGULAR_OUT_RATE = 1.5;
	public static final double NEW_RELEASE_OUT_RATE = 3;
	public static final double CHILDREN_OUT_RATE = 1.5;

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
		return getMovie().getPriceCode().computeRentalPoints(getDaysRented());
	}

	public double calcAllAmount() {
		return getMovie().getPriceCode().computeAmount(getDaysRented());
	}

}
