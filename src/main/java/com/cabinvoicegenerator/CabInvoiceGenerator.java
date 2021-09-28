package com.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;

public class CabInvoiceGenerator {
	private final int MINIMUM_FARE = 5;
	
	/**
	 * method used to calculate the fare of cab
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(int distance, double time) {
		double cost = distance * 10;
		cost += time * 1;
		
		return cost > MINIMUM_FARE ? cost:MINIMUM_FARE;
	}

	/**
	 * method to calculate the aggregate
	 * @param multipleRide
	 * @return
	 */
	public double getAggregateFare(MultipleRide[] multipleRide) {
		double totalFare = 0;
		for(MultipleRide ride: multipleRide) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}

	/**
	 * method used to write enhanced invoice where total rides, total fares and average fare is added
	 * @param multipleRide
	 * @return
	 */
	public Invoice enhancedInvoice(MultipleRide[] multipleRide) {
		double totalFare = 0;
		for(MultipleRide ride: multipleRide) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		
		Invoice invoice = new Invoice(totalFare, multipleRide.length);
		
		return invoice;
	}
}
