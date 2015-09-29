package com.labouardy.tp1;

import static com.labouardy.tp1.Rental.*;

public class Children extends PriceCodeIt{

	public Children(){
		super(AMOUNT_CHILDRENS, CHILDREN_FLAT_RATE, CHILDREN_OUT_RATE);
	}
	
	@Override
	public int computeRentalPoints(int nbrOfDays) {
		return 1;
	}
	
	public PriceCode clone() throws CloneNotSupportedException{
		return (PriceCode) super.clone();
	}

}
