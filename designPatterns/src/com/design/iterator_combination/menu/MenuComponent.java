package com.design.iterator_combination.menu;

import java.util.Iterator;

public abstract class MenuComponent {

	public void addComponent(MenuComponent component) {}
	
	public abstract void print();
	
	public abstract Iterator<MenuComponent> createIterator();
}
