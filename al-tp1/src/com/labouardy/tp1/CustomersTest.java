package com.labouardy.tp1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomersTest {
	private Customers c;
	
	@Before
	public void setUp() throws Exception {
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
	}

	@Test
	public void testStatement() {
		assertEquals("Rental Record for Mohamed\n	hobbit	12.0 \n	spiderman	2.0 \n	spy	7.5 \nAmount owned is 21.5\nYou earned 4 frequent renter points", c.statement());
	}

}
