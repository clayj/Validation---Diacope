package edu.utsa.cs.SalesTax;

public class SalesTax {

	private String startDate, endDate;
	private double percent;
	
	public SalesTax(double p, String sD, String eD) {
		this.percent = p;
		this.startDate = sD;
		this.endDate = eD;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
	
	public double getPercent() {
		return this.percent;
	}
	
	public void print() {
		System.out.printf("%.3f %s %s\n", percent, startDate, endDate);
	}
}
