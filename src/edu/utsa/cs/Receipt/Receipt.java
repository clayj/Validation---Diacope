package edu.utsa.cs.Receipt;

import java.util.Iterator;
import java.util.LinkedList;

import edu.utsa.cs.Item.ReceiptItem;
import edu.utsa.cs.Main.Main;

public class Receipt {

	LinkedList<ReceiptItem> receipt;
	private double total, taxableTotal;
	private String date;
	
	public Receipt(String date) {
		this.date = date;
		receipt = new LinkedList<ReceiptItem>();
		total = 0;
		taxableTotal = 0;
	}
	
	public boolean addItem(ReceiptItem r) {
		return receipt.add(r);
	}
	
	public void print() {
		System.out.println();
		Iterator<ReceiptItem> i = receipt.iterator();
		int counter = 1;
		int itemCount = 0;
		if (Main.debug) {
		System.out.println("          111111111122222222223333333333444");
		System.out.println(" 123456789012345678901234567890123456789012");
		}
		System.out.println("+------------------------------------------+");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|           HOGGLEY-WOGGLEY, INC           |");
		System.out.println("|                 Store 358                |");
		System.out.println("|                                          |");
		while (i.hasNext()) {
			ReceiptItem rI = i.next();
			switch (rI.getType()) {
			case 'F':
				int lineLen = 0;
				System.out.print("|" + counter);
				lineLen += (counter + "").length();
				lineLen += printPadding(lineLen, 4);
				System.out.print(rI.getName());
				lineLen += rI.getName().length();
				lineLen += printPadding(lineLen, 30);
				System.out.print(rI.getCat()+"" + rI.getType()+"");
				lineLen += 2;
				reversePadding(rI.getBPrice(), lineLen, 42);
				total += rI.getQuantity() * rI.getBPrice();
				itemCount += rI.getQuantity();
				break;
									// WILL BE UNUSED, OVERHAULING THIS
			case 'S': 
				if (rI.getQuantity() > 1) {
					System.out.printf("\n");
													// PADDING
					if (rI.getQuantity() < 10) {
						System.out.printf("        %d", rI.getQuantity());
					} else if (rI.getQuantity() < 100) {
				        System.out.printf("       %d", rI.getQuantity());
					} else if (rI.getQuantity() < 1000) {
						System.out.printf("      %d", rI.getQuantity());
					} else {
						throw new IllegalArgumentException();
					}
					System.out.printf(" Ea. @   1/    %.2f F    %.2f\n", rI.getBPrice(), (rI.getQuantity() * rI.getBPrice()));
				
				} else {
					for (int j = rI.getName().length(); j < 26; j++)
						System.out.printf(" ");
					System.out.printf("F    %.2f\n", rI.getBPrice());
				}
				itemCount += rI.getQuantity();
				break;
			}
			counter++;
		}
		if (taxableTotal > 0) {
			System.out.print("|******** Sale Subtotal***");
		}
		System.out.print("|************ Total Sale");
		reversePadding(total, 23, 42);
		System.out.println("|=================================         |");
		System.out.print("|    ITEMS PURCHASED:");
		reversePadding(itemCount, 20, 25);
		System.out.println("|=================================         |");
		System.out.print("|    SAVED TODAY");
		reversePadding(0.00, 15, 42);
		System.out.println("|=================================         |");
		System.out.println("|                                          |");
		System.out.println("|    Date:              " + date + "         |");
		System.out.println("|                                          |");
		System.out.println("+------------------------------------------+");
	}
	
	private int printPadding(int curLen, int total) {
		for (int i = curLen; i < total; i++) {
			System.out.print(" ");
		}
		return (total - curLen);
	}
	
	private void reversePadding(double value, int current, int total) {
		value = (double) Math.round(value * 100) / 100;
		int priceLen = (value+"").length();
		if (priceLen < 4) priceLen = 4;
		for (int i = current + priceLen; i < total - 2; i++) {
			System.out.print(" ");
		}
		System.out.printf("%.2f  |\n", value);
	}
	
	private void reversePadding(int value, int current, int total) {
		int valLen = (value+"").length();
		for (int i = current + valLen; i < total; i++) {
			System.out.print(" ");
		}
		System.out.println(value + "                 |");
	}
}
