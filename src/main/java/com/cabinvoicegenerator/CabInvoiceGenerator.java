package com.cabinvoicegenerator;

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

	public double getAggregateFare(MultipleRide[] multipleRide) {
		double totalFare = 0;
		for(MultipleRide ride: multipleRide) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare/multipleRide.length;
	}
}
