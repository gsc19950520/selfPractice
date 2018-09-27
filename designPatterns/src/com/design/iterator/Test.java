package com.design.iterator;

public class Test {

	public static void main(String[] args) {
		Waitress w = new Waitress(new PancakeHouseMenu(), new DinerMenu());
		w.printDiner();
		w.printHouseMenu();
	}
}
