package com.design.iterator;

import java.util.Iterator;

import com.design.iterator.iterator.DinerMenuIterator;

public class DinerMenu {

	static final int maxCount = 10;
	MenuItem[] menuItems;
	
	public DinerMenu() {
		menuItems = new MenuItem[maxCount];
		menuItems[0] = new MenuItem("����ţ��", 33.99, false, "��ζ");
		menuItems[1] = new MenuItem("�����ײ�", 3.99, true, "��ζ");
		menuItems[2] = new MenuItem("�������", 13.99, true, "��ζ");
		menuItems[3] = new MenuItem("��������", 43.99, false, "��ζ");
	}
	
	public Iterator<MenuItem> createIterator() {
		return new DinerMenuIterator(menuItems);
	}
}
