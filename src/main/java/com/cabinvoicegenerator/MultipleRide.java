package com.cabinvoicegenerator;

public class MultipleRide {
	int userId;
	int distance;
	int time;
	
	public MultipleRide(int userId,int distance, int time) {
		this.userId = userId;
		this.distance = distance;
		this.time = time;
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
