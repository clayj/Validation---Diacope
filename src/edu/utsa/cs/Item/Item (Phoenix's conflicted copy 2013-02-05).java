package edu.utsa.cs.Item;

import java.util.regex.Pattern;

public class Item {

	private String upc;
	private String name;
	private char type;
	private char cat;
	private double bPrice;
	private String bPriceStart;
	private String bPriceStop;
	private double discount;
	private String disStart;
	private String disStop;
	private int buyM;
	private int getN;
	private String buyMNStart;
	private String buyMNStop;
	private char taxable;
	
	public Item() {
		try {
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	public Item(String upc, String name, char type, char cat,
				double bPrice, String bpStart, String bpStop,
				double dis, String dStart, String dStop,
				int buyM, int getN, String buyMNStart, String buyMNStop, char taxable) {
		if (upc.length() <= 10 && checkAlpha(upc))
			this.upc = upc;
		if (name.length() <= 25 && checkAlpha(name))
			this.name = name;
		if (type == 'F' || type == 'P' || type == 'Q')
			this.type = type;
		if (cat == 'M' || cat == 'P' || cat == 'K' || cat == 'D')
			this.cat = cat;
		if (bPrice > 0.00)
			this.bPrice = bPrice;
		if (checkDate(bpStart))
			this.bPriceStart = bpStart;
		if (checkDate(bpStop))
			this.bPriceStop = bpStop;
		if (dis > 0.00)
			this.discount = dis;
		if (checkDate(dStart))
			this.disStart = dStart;
		if (checkDate(dStop))
			this.disStop = dStop;
		this.buyM = buyM;
		this.getN = getN;
		if (checkDate(buyMNStart))
			this.buyMNStart = buyMNStart;
		if (checkDate(buyMNStop))
			this.buyMNStop = buyMNStop;
		if (taxable == 'T' || taxable == 'F')
			this.taxable = taxable;
	}
	
	private boolean checkAlpha(String arg) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9]");
		return p.matcher(arg).find();
	}
	
	private boolean checkDate(String arg) {
		Pattern p = Pattern.compile("^[0-9]+/[0-9]+/2013$");
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
	
	public String getBPStart() {
		return bPriceStart;
	}
	
	public String getBPStop() {
		return bPriceStop;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public String getDiscountStart() {
		return disStart;
	}
	
	public String getDiscountStop() {
		return disStop;
	}
	
	public int getBuyM() {
		return buyM;
	}
	
	public int getGetN() {
		return getN;
	}
	
	public String getBuyMNStart() {
		return buyMNStart;
	}
	
	public String getBuyMNStop() {
		return buyMNStop;
	}
	
	public char getTaxable() {
		return taxable;
	}
	
	public String toString() {
		return upc + " " + name + " " + type + " " + cat + " " + bPrice + " " + bPriceStart + " " + bPriceStop + " " + discount + " " + disStart + " " + disStop + " " + buyM + " " + getN + " " + buyMNStart + " " + buyMNStop + " " + taxable;
	}
}
