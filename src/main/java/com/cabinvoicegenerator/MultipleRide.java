package com.cabinvoicegenerator;

import com.cabinvoicegenerator.CabInvoiceGenerator.Ride;

public class MultipleRide {
	int userId;
	int distance;
	int time;
	Ride type;
	
	public MultipleRide(int userId,int distance, int time, Ride type) {
		this.userId = userId;
		this.distance = distance;
		this.time = time;
		this.type = type;
	}
	

	public Ride getType() {
		return type;
	}


	public void setType(Ride type) {
		this.type = type;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
