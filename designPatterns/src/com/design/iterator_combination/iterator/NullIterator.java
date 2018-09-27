package com.design.iterator_combination.iterator;

import java.util.Iterator;

import com.design.iterator_combination.menu.MenuComponent;

public class NullIterator implements Iterator<MenuComponent>{

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public MenuComponent next() {
		return null;
	}

}
