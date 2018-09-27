package com.design.iterator_combination;


import com.design.iterator_combination.menu.Menu;
import com.design.iterator_combination.menu.MenuComponent;
import com.design.iterator_combination.menu.MenuItem;

public class Test {

	public static void main(String[] args) {
		MenuComponent menu1 = new Menu("ĞÂ½®²Ëµ¥","999");
		menu1.addComponent(new MenuItem("²ÍÌüÅ£Èâ", 33.99, false, "ÃÀÎ¶"));
		menu1.addComponent(new MenuItem("²ÍÌüÅ£Èâ2", 34.99, true, "ÃÀÎ¶"));
		menu1.addComponent(new MenuItem("²ÍÌüÅ£Èâ3", 37.99, false, "ÃÀÎ¶"));
		
		MenuComponent menu2 = new Menu("Î÷°²²Ëµ¥","999");
		menu2.addComponent(new MenuItem("²ÍÌü2Å£Èâ", 33.99, false, "ÃÀÎ¶"));
		menu2.addComponent(new MenuItem("²ÍÌü2Å£Èâ2", 34.99, false, "ÃÀÎ¶"));
		menu2.addComponent(new MenuItem("²ÍÌü2Å£Èâ3", 37.99, true, "ÃÀÎ¶"));
		
		MenuComponent bigMenu = new Menu("ÖĞ¹ú²Ëµ¥","999");
		bigMenu.addComponent(menu2);
		bigMenu.addComponent(menu1);
		
		Waitress w = new Waitress(bigMenu);
//		w.print();
		w.printVegetable();
	}
}
