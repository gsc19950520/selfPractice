package com.design.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu {

	private List<MenuItem> list;
	
	public PancakeHouseMenu() {
		list = new ArrayList<>();
		list.add(new MenuItem("����ţ��", 33.99, false, "��ζ"));
		list.add(new MenuItem("���Ӱײ�", 3.99, true, "��ζ"));
		list.add(new MenuItem("�������", 13.99, true, "��ζ"));
		list.add(new MenuItem("����ţ��", 23.99, false, "��ζ"));
	}
	
	public Iterator<MenuItem> createIterator() {
		return list.iterator();
	}
}
