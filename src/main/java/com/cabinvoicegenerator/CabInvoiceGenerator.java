package com.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;

public class CabInvoiceGenerator {
	public enum Ride {PREMIUM, NORMAL}
	private final int NORMAL_MINIMUM_FARE = 5;
	private final int PREMIUM_MINIMUM_FARE = 20;
	private final int NORMAL_FARE_KM = 10;
	private final int PREMIUM_FARE_KM = 15;
	private final int NORMAL_FARE_MIN = 1;
	private final int PREMIUM_FARE_MIN = 2;
	
	/**
	 * method used to calculate the fare of cab
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(Ride type,int distance, double time) {
		if(type == Ride.NORMAL) {
			double cost = distance * NORMAL_FARE_KM;
			cost += time * NORMAL_FARE_MIN;
			
			return cost > NORMAL_MINIMUM_FARE ? cost:NORMAL_MINIMUM_FARE;
		}else {
			double cost = distance * PREMIUM_FARE_KM;
			cost += time * PREMIUM_FARE_MIN;
			
			return cost > PREMIUM_MINIMUM_FARE ? cost:PREMIUM_MINIMUM_FARE;
		}
	}

	/**
	 * method to calculate the aggregate
	 * @param multipleRide
	 * @return
	 */
	public double getAggregateFare(List<MultipleRide> multipleRide) {
		double totalFare = 0;
		for(MultipleRide ride: multipleRide) {
			totalFare += calculateFare(ride.getType(),ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}

	/**
	 * method used to write enhanced invoice where total rides, total fares and average fare is added
	 * @param multipleRide
	 * @return
	 */
	public Invoice enhancedInvoice(List<MultipleRide> multipleRide) {
		double totalFare = 0;
		for(MultipleRide ride: multipleRide) {
			totalFare += calculateFare(ride.getType(),ride.getDistance(), ride.getTime());
		}
		
		Invoice invoice = new Invoice(totalFare, multipleRide.size());
		
		return invoice;
	}
}
