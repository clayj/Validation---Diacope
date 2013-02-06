package edu.utsa.cs.Cards;

public class Card {

	private char type;
	private long number;
	private double available;
	
	public Card(char type, long num, double avail) {
		if (type == 'C' || type == 'D')
			this.type = type;
		if (checkNum(num))
			this.number = num;
		if (avail >= 0.00)
			this.available = avail;
	}
	
	public char getType() {
		return type;
	}
	
	public long getNumber() {
		return number;
	}
	
	public double getAvailableBalance() {
		return available;
	}
	
	private boolean checkNum(long n) {
		if (n / 1000000000000000L > 0 && n / 1000000000000000L < 10)
			return true;
		else
			return false;
	}
	
	public String toString() {
		return type + " " + number + " " + available;
	}
}
