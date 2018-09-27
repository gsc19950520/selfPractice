package com.design.iterator_combination.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.design.iterator_combination.iterator.CompositeIterator;

public class Menu extends MenuComponent{

	private List<MenuComponent> list;
	private String name;
	private String description;
	
	public Menu(String name, String description) {
		list = new ArrayList<>();
		this.name = name;
		this.description = description;
	}

	public void addComponent(MenuComponent component) {
		list.add(component);
	}

	public void print() {
		System.out.println("Menu [name=" + name + ", description=" + description + "]");
		Iterator<MenuComponent> createIterator = list.iterator();
		while(createIterator.hasNext()) {
			MenuComponent next = createIterator.next();
			next.print();
		}
	}

	@Override
	public Iterator<MenuComponent> createIterator() {
		return new CompositeIterator(list.iterator());
	}
}
