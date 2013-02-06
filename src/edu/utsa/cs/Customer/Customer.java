package edu.utsa.cs.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

import edu.utsa.cs.Item.ItemDatabase;
import edu.utsa.cs.Item.ReceiptItem;
import edu.utsa.cs.Receipt.Receipt;

public class Customer {

	private String date;
	private Scanner custDataIn;
	private Receipt receipt;
	
	public Customer() {
		try {
			custDataIn = new Scanner(new File("data/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.date = "";
		receipt = new Receipt();
	}
	
	public String getDate() {
		return date;
	}
	
	public void readItems() {
		while (custDataIn.hasNextLine()) {
			String temp = custDataIn.nextLine();
			if (checkDate(temp))
				date = temp;
			else {
				throw new IllegalArgumentException();
			}
			while (custDataIn.hasNextLine()) {
				String line = custDataIn.next();
				if (line.charAt(0) != '#') {
					ReceiptItem rI = new ReceiptItem(line.substring(0,10));
					switch (ItemDatabase.getFromUPC(rI.getUPC()).getType()) {
					case 'F':
						rI.setQuantity(1);
						if (custDataIn.hasNextInt())
							rI.setQuantity(custDataIn.nextInt());
						break;
					case 'P':
					case 'Q':
					}
					receipt.addItem(rI);
				} else {
					printReceipt();
					try {
						custDataIn.nextLine();
					} catch (NoSuchElementException e) {
						
					}
					receipt = new Receipt();
					break;
				}
			}
		}
	}
	
	private void printReceipt() {
		receipt.print();
	}
	
	private boolean checkDate(String arg) {
		Pattern p = Pattern.compile("^[0-9]+/[0-9]+/2013$");
		return p.matcher(arg).find();
	}
}
