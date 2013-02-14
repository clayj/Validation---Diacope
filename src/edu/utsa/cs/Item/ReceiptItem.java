package edu.utsa.cs.Item;

public class ReceiptItem {
	
	private int quantity;
	private double poundage;
	private Item item;
	
	public ReceiptItem(String upc) {
		item = ItemDatabase.getFromUPC(upc);
		if (item == null) {
			throw new IllegalArgumentException();
		}
	}
	
	public String getUPC() {
		return item.getUPC();
	}

	public String getName() {
		return item.getName();
	}
	
	public char getTaxable() {
		return item.getTaxable();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getBPrice() {
		return item.getBPrice();
	}
	
	public char getCat() {
		return item.getCat();
	}
	
	public void setQuantity(int q) {
		this.quantity = q;
	}
	
	public char getType() {
		return item.getType();
	}
	
	public double getPoundage() {
		return poundage;
	}
}
