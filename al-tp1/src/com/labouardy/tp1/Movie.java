package com.labouardy.tp1;

public class Movie {
	public static final PriceCode CHILDRENS = new Children();
	public static final PriceCode REGULAR = new Regular();
	public static final PriceCode NEW_RELEASE = new NewRelease();

	private String title;
	private PriceCode priceCode;

	public Movie(String title, PriceCode priceCode) {
		this.title = title;
		try {
			this.priceCode = priceCode.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public PriceCode getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(PriceCode priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

}
