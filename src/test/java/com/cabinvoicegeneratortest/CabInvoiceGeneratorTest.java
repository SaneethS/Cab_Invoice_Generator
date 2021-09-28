package com.cabinvoicegeneratortest;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cabinvoicegenerator.CabInvoiceGenerator;
import com.cabinvoicegenerator.Invoice;
import com.cabinvoicegenerator.MultipleRide;
import com.cabinvoicegenerator.RideRepository;

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
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new MultipleRide(1,10,60) );
		rideRepository.addRide(new MultipleRide(1,20,75));
		double calculateAggregateFare = cabInvoiceGenerator.getAggregateFare(rideRepository.getAllRides());
		double expectedResult = 435;
		
		double epsilon = 1e-15;
		
		Assert.assertEquals(expectedResult, calculateAggregateFare,epsilon);

	}
	
	/**
	 * test method which is used to check for enchanced invoice
	 */
	@Test
	public void enchancedInvoiceShouldMatchExpectedResult() {
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new MultipleRide(1,10,60) );
		rideRepository.addRide(new MultipleRide(1,20,75));
		Invoice invoice = cabInvoiceGenerator.enhancedInvoice(rideRepository.getAllRides());
		double expectedResultRides = 2;
		double expectedResultFare = 435;
		double expectedResultAveg = 217.5;
		
		double epsilon = 1e-15;
		
		Assert.assertEquals(expectedResultRides, invoice.getTotalRides(), epsilon);
		Assert.assertEquals(expectedResultFare, invoice.getTotalFares(), epsilon);
		Assert.assertEquals(expectedResultAveg, invoice.getAvgFares(), epsilon);
	}
	
	/**
	 * test method to get invoice for multiple users to get expected result
	 */
	@Test
	public void invoiceForMultipleUsersMatchExpectedResult() {
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new MultipleRide(1,10,60) );
		rideRepository.addRide(new MultipleRide(1,20,75));
		rideRepository.addRide(new MultipleRide(2,11,45) );
		rideRepository.addRide(new MultipleRide(1,15,50));
		rideRepository.addRide(new MultipleRide(2,30,80) );
		rideRepository.addRide(new MultipleRide(1,17,64));
		
		//user 1
		Invoice invoice = cabInvoiceGenerator.enhancedInvoice(rideRepository.getAllRides().stream()
				.filter(ride -> ride.getUserId()==1).collect(Collectors.toList()));
		
		int expectedResultRides = 4;
		double expectedResultFare = 869;
		double expectedResultAveg = 217.25;
		double epsilon = 1e-15;
		
		Assert.assertEquals(expectedResultRides, invoice.getTotalRides(), epsilon);
		Assert.assertEquals(expectedResultFare, invoice.getTotalFares(), epsilon);
		Assert.assertEquals(expectedResultAveg, invoice.getAvgFares(), epsilon);
		
		//user 2
		invoice = cabInvoiceGenerator.enhancedInvoice(rideRepository.getAllRides().stream()
				.filter(ride -> ride.getUserId()==2).collect(Collectors.toList()));
		
		expectedResultRides = 2;
		expectedResultFare = 535;
		expectedResultAveg = 267.5;
		
		Assert.assertEquals(expectedResultRides, invoice.getTotalRides(), epsilon);
		Assert.assertEquals(expectedResultFare, invoice.getTotalFares(), epsilon);
		Assert.assertEquals(expectedResultAveg, invoice.getAvgFares(), epsilon);
	}
	
}
