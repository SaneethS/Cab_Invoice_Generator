package com.cabinvoicegeneratortest;

import org.junit.Assert;
import org.junit.Test;

import com.cabinvoicegenerator.CabInvoiceGenerator;

public class CabInvoiceGeneratorTest {
	
	/**
	 * test method to check whether the fare matches expected
	 * result
	 */
	@Test
	public void fareMatchesExpectedResult() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		int distance = 10;
		double time = 60;
		double calculateFare = cabInvoiceGenerator.calculateFare(distance,time);
		double expectedResult = 160;
		double epsilon = 1e-15;
		
		Assert.assertEquals(expectedResult, calculateFare,epsilon);
	}
}
