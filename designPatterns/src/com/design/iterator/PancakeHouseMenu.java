package com.design.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu {

	private List<MenuItem> list;
	
	public PancakeHouseMenu() {
		list = new ArrayList<>();
		list.add(new MenuItem("屋子牛肉", 33.99, false, "美味"));
		list.add(new MenuItem("屋子白菜", 3.99, true, "美味"));
		list.add(new MenuItem("屋子青菜", 13.99, true, "美味"));
		list.add(new MenuItem("屋子牛肉", 23.99, false, "美味"));
	}
	
	public Iterator<MenuItem> createIterator() {
		return list.iterator();
	}
}
