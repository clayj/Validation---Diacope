package edu.utsa.cs.Main;

import edu.utsa.cs.Item.ItemDatabase;

public class Main {

	public Main() {
		init();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
	}
	
	private void init() {
		// load database of items
		System.out.println("Loading Database...");
		new ItemDatabase();
	}

}
