package com.labouardy.tp1;

public interface PriceCode extends Cloneable{
	public double computeAmount(int nbrOfDays);
	public int computeRentalPoints(int nbrOfDays);
	public PriceCode clone() throws CloneNotSupportedException;
}
