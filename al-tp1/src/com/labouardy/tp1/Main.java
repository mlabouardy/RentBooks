package com.labouardy.tp1;

public class Main {
	
	
	public static void main(String[] args){
		Customers c;
		Movie m1, m2, m3;
		Rental r1, r2, r3;

		m1=new Movie("hobbit", Movie.NEW_RELEASE);
		m2=new Movie("spiderman", Movie.REGULAR);
		m3=new Movie("spy", Movie.CHILDRENS);

		r1=new Rental(m1, 4);
		r2=new Rental(m2, 2);
		r3=new Rental(m3, 7);

		c=new Customers("Mohamed");
		c.addRental(r1);
		c.addRental(r2);
		c.addRental(r3);
		
		System.out.println(c.statement());
		
	    
	}
}
