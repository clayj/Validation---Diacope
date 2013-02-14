package edu.utsa.cs.Receipt;

import java.util.Iterator;
import java.util.LinkedList;

import edu.utsa.cs.Item.ReceiptItem;

public class Receipt {

	LinkedList<ReceiptItem> receipt;
	private double total, taxableTotal;
	
	public Receipt() {
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
		while (i.hasNext()) {
			ReceiptItem rI = (ReceiptItem) i.next();
			switch (rI.getType()) {
			case 'F': System.out.print(counter + "  " + rI.getName());
				if (rI.getQuantity() > 1) {
					System.out.printf("\n");
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
				total += rI.getQuantity() * rI.getBPrice();
				itemCount += rI.getQuantity();
				break;
			}
			counter++;
		}
		if (taxableTotal > 0) {
			System.out.printf("*********** Sale Subtotal***  %.2f\n", total);
		}
		System.out.printf("************** Total Sale***    %.2f\n", total);
	}
}
