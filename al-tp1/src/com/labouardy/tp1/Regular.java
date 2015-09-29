package com.labouardy.tp1;


import static com.labouardy.tp1.Rental.*;

public class Regular extends PriceCodeIt{

	public Regular() {
		super(AMOUNT_REGULAR, REGULAR_FLAT_RATE ,REGULAR_OUT_RATE);
	}
	
	@Override
	public int computeRentalPoints(int nbrOfDays) {
		return 1;
	}

	public PriceCode clone() throws CloneNotSupportedException{
		return (PriceCode) super.clone();
	}
}
