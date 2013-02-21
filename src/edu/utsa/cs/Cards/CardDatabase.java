package edu.utsa.cs.Cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CardDatabase {

	public static LinkedList<Card> database;
	
	public CardDatabase() {
		database = new LinkedList<Card>();
		loadCards();
	}
	
	private void loadCards() {
		Scanner cardIn = null;
		try {
			cardIn = new Scanner(new File("data/cards.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (cardIn.hasNext()) {
			StringTokenizer st = new StringTokenizer(cardIn.nextLine(), "|");
			Card c = new Card(st.nextToken().charAt(0), Long.parseLong(st.nextToken()), Double.parseDouble(st.nextToken()));
			database.add(c);
		}
	}
	
	public static void print() {
		Iterator<Card> i = database.iterator();
		while (i.hasNext()) {
			i.next().print();
		}
	}
}
