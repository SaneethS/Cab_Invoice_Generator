package com.cabinvoicegeneratortest;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cabinvoicegenerator.CabInvoiceGenerator;
import com.cabinvoicegenerator.Invoice;
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
	
	/**
	 * test method to check expected aggregate to be correct
	 */
	@Test
	public void aggregateFareMatchesExpectedResult() {
		MultipleRide[] multipleRide = {new MultipleRide(10,60), new MultipleRide(20,75)};
		double calculateAggregateFare = cabInvoiceGenerator.getAggregateFare(multipleRide);
		double expectedResult = 435;
		
		double epsilon = 1e-15;
		
		Assert.assertEquals(expectedResult, calculateAggregateFare,epsilon);

	}
	
	/**
	 * test method which is used to check for enchanced invoice
	 */
	@Test
	public void enchancedInvoiceShouldMatchExpectedResult() {
		MultipleRide[] multipleRide = {new MultipleRide(10,60), new MultipleRide(20,75)};
		Invoice invoice = cabInvoiceGenerator.enhancedInvoice(multipleRide);
		double expectedResultRides = 2;
		double expectedResultFare = 435;
		double expectedResultAveg = 217.5;
		
		double epsilon = 1e-15;
		
		Assert.assertEquals(expectedResultRides, invoice.getTotalRides(), epsilon);
		Assert.assertEquals(expectedResultFare, invoice.getTotalFares(), epsilon);
		Assert.assertEquals(expectedResultAveg, invoice.getAvgFares(), epsilon);
	}
}
