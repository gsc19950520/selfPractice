package com.design.iterator;

import java.util.Iterator;

public class Waitress {

	PancakeHouseMenu houseMenu;
	DinerMenu dinerMenu;
	
	
	public Waitress(PancakeHouseMenu houseMenu, DinerMenu dinerMenu) {
		this.houseMenu = houseMenu;
		this.dinerMenu = dinerMenu;
	}
	
	public void printDiner() {
		print(dinerMenu.createIterator());
	}
	
	public void printHouseMenu() {
		print(houseMenu.createIterator());
	}

	public void print(Iterator<MenuItem> iterator) {
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
