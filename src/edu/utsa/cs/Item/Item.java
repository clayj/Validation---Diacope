package edu.utsa.cs.Item;

import java.util.regex.Pattern;

public class Item {

	private String upc;
	private String name;
	private char type;
	private char cat;
	private double bPrice;
	
	public Item() {
		try {
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	public Item(String upc, String name, char type, char cat, double bPrice) {
		if (upc.length() != 10 && checkAlpha(upc))
			this.upc = upc;
		if (name.length() <= 20 && checkAlpha(name))
			this.name = name;
		if (type == 'F' || type == 'P' || type == 'Q')
			this.type = type;
		if (cat == 'M' || cat == 'P' || cat == 'K' || cat == 'D')
			this.cat = cat;
		if (bPrice > 0.00)
			this.bPrice = bPrice;
	}
	
	private boolean checkAlpha(String arg) {
		Pattern p = Pattern.compile("[^a-zA-Z0-9]");
		return p.matcher(arg).find();
	}
	
	public String getUPC() {
		return upc;
	}
	
	public String getName() {
		return name;
	}
	
	public char getType() {
		return type;
	}
	
	public char getCat() {
		return cat;
	}
	
	public double getBPrice() {
		return bPrice;
	}
}
