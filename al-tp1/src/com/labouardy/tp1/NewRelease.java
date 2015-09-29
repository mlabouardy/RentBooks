package com.labouardy.tp1;

import static com.labouardy.tp1.Rental.*;

public class NewRelease extends PriceCodeIt{

	public NewRelease(){
		super(AMOUNT_NEW_RELEASE, NEW_RELEASE_FLAT_RATE, NEW_RELEASE_OUT_RATE);
	}
	
	@Override
	public int computeRentalPoints(int nbrOfDays) {
		return (nbrOfDays>1)?1:2;
	}

	public PriceCode clone() throws CloneNotSupportedException{
		return (PriceCode) super.clone();
	}
}
