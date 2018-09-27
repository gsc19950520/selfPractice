package com.design.iterator_combination;


import com.design.iterator_combination.menu.Menu;
import com.design.iterator_combination.menu.MenuComponent;
import com.design.iterator_combination.menu.MenuItem;

public class Test {

	public static void main(String[] args) {
		MenuComponent menu1 = new Menu("�½��˵�","999");
		menu1.addComponent(new MenuItem("����ţ��", 33.99, false, "��ζ"));
		menu1.addComponent(new MenuItem("����ţ��2", 34.99, true, "��ζ"));
		menu1.addComponent(new MenuItem("����ţ��3", 37.99, false, "��ζ"));
		
		MenuComponent menu2 = new Menu("�����˵�","999");
		menu2.addComponent(new MenuItem("����2ţ��", 33.99, false, "��ζ"));
		menu2.addComponent(new MenuItem("����2ţ��2", 34.99, false, "��ζ"));
		menu2.addComponent(new MenuItem("����2ţ��3", 37.99, true, "��ζ"));
		
		MenuComponent bigMenu = new Menu("�й��˵�","999");
		bigMenu.addComponent(menu2);
		bigMenu.addComponent(menu1);
		
		Waitress w = new Waitress(bigMenu);
//		w.print();
		w.printVegetable();
	}
}
