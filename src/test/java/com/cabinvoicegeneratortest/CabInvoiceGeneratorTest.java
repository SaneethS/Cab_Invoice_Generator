package com.cabinvoicegeneratortest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cabinvoicegenerator.CabInvoiceGenerator;
import com.cabinvoicegenerator.MultipleRide;

public class CabInvoiceGeneratorTest {
	CabInvoiceGenerator cabInvoiceGenerator;
	
	@Before
	public void init() {
		cabInvoiceGenerator = new CabInvoiceGenerator();
	}
	/**
	 * test method to check whether the fare matches expected
	 * result
	 */
	@Test
	public void fareMatchesExpectedResult() {
		int distance = 10;
		double time = 60;
		double calculateFare = cabInvoiceGenerator.calculateFare(distance,time);
		double expectedResult = 160;
		double epsilon = 1e-15;
		
		Assert.assertEquals(expectedResult, calculateFare,epsilon);
	}
	
	@Test
	public void aggregateFareMatchesExpectedResult() {
		MultipleRide[] multipleRide = {new MultipleRide(10,60), new MultipleRide(20,75)};
		double calculateAggregateFare = cabInvoiceGenerator.getAggregateFare(multipleRide);
		double expectedResult = 217.5;
		
		double epsilon = 1e-15;
		
		Assert.assertEquals(expectedResult, calculateAggregateFare,epsilon);

	}
}
