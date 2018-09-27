package com.design.iterator.iterator;

import java.util.Iterator;

import com.design.iterator.MenuItem;

public class DinerMenuIterator implements Iterator<MenuItem>{
	
	private MenuItem[] menuItems;
	int length = 0;

	public DinerMenuIterator(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}
	
	@Override
	public boolean hasNext() {
		if(length < menuItems.length && menuItems[length] != null) {
			return true;
		}
		return false;
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem = menuItems[length];
		length++;
		return menuItem;
	}

	
}
