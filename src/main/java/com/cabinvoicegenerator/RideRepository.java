package com.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {
	private List<MultipleRide> list;
	
	public RideRepository() {
		list = new ArrayList<MultipleRide>();
	}
	
	public void addRide(MultipleRide ride) {
		list.add(ride);
	}
	
	public List<MultipleRide> getAllRides(){
		return list;
	}
}
