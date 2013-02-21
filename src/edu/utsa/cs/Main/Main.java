package edu.utsa.cs.Main;

import edu.utsa.cs.Cards.CardDatabase;
import edu.utsa.cs.Customer.Customer;
import edu.utsa.cs.Item.ItemDatabase;
import edu.utsa.cs.SalesTax.SalesTaxDatabase;

public class Main {
	
	public static boolean debug = false;
	
	public static void main(String[] args) {
		debug = true;
		new Main().init();
		Customer c = new Customer();
		c.readItems();
//		printDatabases();
	}
	
	private void init() {
		// load database of items
		System.out.println("Loading Item Database...");
		new ItemDatabase();
		System.out.println("Loading Card Database...");
		new CardDatabase();
		System.out.println("Loading Sales Tax Database...");
		new SalesTaxDatabase();
	}
	
	private static void printDatabases() {
		ItemDatabase.print();
		CardDatabase.print();
		SalesTaxDatabase.print();
	}

}
