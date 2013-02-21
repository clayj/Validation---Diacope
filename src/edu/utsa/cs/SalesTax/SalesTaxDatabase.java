package edu.utsa.cs.SalesTax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SalesTaxDatabase {
	
	public static LinkedList<SalesTax> database;
	
	public SalesTaxDatabase() {
		database = new LinkedList<SalesTax>();
		loadTaxInfo();
	}
	
	private void loadTaxInfo() {
		Scanner taxIn = null;
		try {
			taxIn = new Scanner(new File("data/salestax.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (taxIn != null && taxIn.hasNext()) {
			StringTokenizer st = new StringTokenizer(taxIn.nextLine(), ",");
			SalesTax salesT = new SalesTax(Double.parseDouble(st.nextToken()), st.nextToken(), st.nextToken());
			database.add(salesT);
		}
	}
	
	public static void print() {
		Iterator<SalesTax> i = database.iterator();
		while (i.hasNext()) {
			i.next().print();
		}
	}
}
