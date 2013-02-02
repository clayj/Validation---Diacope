package edu.utsa.cs.Item;

import java.util.LinkedList;

public class ItemDatabase {

	public static LinkedList<Item> database;
	
	public ItemDatabase() {
		loadItems();
	}
	
	private void loadItems() {
		database.add(new Item("abc", "def", 'F', 'M', 0.01));
	}
}
