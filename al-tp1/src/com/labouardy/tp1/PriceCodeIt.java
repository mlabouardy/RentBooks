package com.labouardy.tp1;

public abstract class PriceCodeIt implements PriceCode{
	private double amount;
	private double flatRate;
	private double outRate;
	
	public PriceCodeIt(double amount, double flatRate, double outRate) {
		this.amount = amount;
		this.flatRate = flatRate;
		this.outRate = outRate;
	}
	
	public double computeAmount(int nbrOfDays){
		double s = 0;
		s += amount;
		if (nbrOfDays > flatRate) {
			s +=  (nbrOfDays - flatRate) * outRate;
		}
		return s;
	}
	
	@Override
	public PriceCode clone() throws CloneNotSupportedException{
		
		return (PriceCode) super.clone();
	}
	
}
