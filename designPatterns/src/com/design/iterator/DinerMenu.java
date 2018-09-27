package com.design.iterator;

import java.util.Iterator;

import com.design.iterator.iterator.DinerMenuIterator;

public class DinerMenu {

	static final int maxCount = 10;
	MenuItem[] menuItems;
	
	public DinerMenu() {
		menuItems = new MenuItem[maxCount];
		menuItems[0] = new MenuItem("²ÍÌüÅ£Èâ", 33.99, false, "ÃÀÎ¶");
		menuItems[1] = new MenuItem("²ÍÌü°×²Ë", 3.99, true, "ÃÀÎ¶");
		menuItems[2] = new MenuItem("²ÍÌüÇà²Ë", 13.99, true, "ÃÀÎ¶");
		menuItems[3] = new MenuItem("²ÍÌüÖíÈâ", 43.99, false, "ÃÀÎ¶");
	}
	
	public Iterator<MenuItem> createIterator() {
		return new DinerMenuIterator(menuItems);
	}
}
