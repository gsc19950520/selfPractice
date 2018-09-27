package com.design.iterator_combination;

import java.util.Iterator;

import com.design.iterator_combination.menu.MenuComponent;
import com.design.iterator_combination.menu.MenuItem;

public class Waitress {

	MenuComponent menuComponent;
	
	public Waitress(MenuComponent menuComponent) {
		this.menuComponent = menuComponent;
	}

	public void print() {
		menuComponent.print();
	}
	
	public void printVegetable() {
		Iterator<MenuComponent> createIterator = menuComponent.createIterator();
		while(createIterator.hasNext()) {
			MenuComponent next = createIterator.next();
			if(next instanceof MenuItem) {
				if(((MenuItem) next).isVegetable()) {
					next.print();
				}
			}
		}
	}
}
