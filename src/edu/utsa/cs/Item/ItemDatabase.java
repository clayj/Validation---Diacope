package edu.utsa.cs.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ItemDatabase {

	public static LinkedList<Item> database;
	
	public ItemDatabase() {
		database = new LinkedList<Item>();
		loadItems();
	}
	
	private void loadItems() {
		Scanner itemIn = null;
		try {
			itemIn = new Scanner(new File("data/items.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (itemIn != null && itemIn.hasNext()) {
			StringTokenizer st = new StringTokenizer(itemIn.nextLine(), "|");
			Item i = new Item(st.nextToken(), st.nextToken(), st.nextToken().charAt(0), st.nextToken().charAt(0), Double.parseDouble(st.nextToken()), st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken(), st.nextToken().charAt(0));
			database.add(i);
		}
	}
	
	public static Item getFromUPC(String arg) {
		Iterator i = database.iterator();
		while (i.hasNext()) {
			Item temp = (Item) i.next();
			if (temp.getUPC().equals(arg))
				return temp;
		}
		return null;
	}
}
