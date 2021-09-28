package com.cabinvoicegenerator;

public class Invoice {
	int totalRides;
	double totalFares;
	double avgFares;
	
	public Invoice(double totalFares, int totalRides) {
		this.totalFares = totalFares;
		this.totalRides = totalRides;
		this.avgFares = totalFares/totalRides;
	}
	
	public int getTotalRides() {
		return totalRides;
	}
	
	public void setTotalRides(int totalRides) {
		this.totalRides = totalRides;
	}
	
	public double getTotalFares() {
		return totalFares;
	}
	
	public void setTotalFares(double totalFares) {
		this.totalFares = totalFares;
	}
	
	public double getAvgFares() {
		return avgFares;
	}
	
	public void setAvgFares(double avgFares) {
		this.avgFares = avgFares;
	}
	
	
}
