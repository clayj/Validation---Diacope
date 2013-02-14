package edu.utsa.cs.Main;

import edu.utsa.cs.Cards.CardDatabase;
import edu.utsa.cs.Customer.Customer;
import edu.utsa.cs.Item.ItemDatabase;

public class Main {
	
	public static boolean debug = false;
	
	public static void main(String[] args) {
		debug = true;
		new Main().init();
		Customer c = new Customer();
		c.readItems();
	}
	
	private void init() {
		// load database of items
		System.out.println("Loading Item Database...");
		new ItemDatabase();
		System.out.println("Loading Card Database...");
		new CardDatabase();
	}

}
