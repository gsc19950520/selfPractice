package com.design.factory.pizza;

import com.design.factory.ingredient.Dough;
import com.design.factory.ingredient.Sauce;

public abstract class Pizza {
	
	String name;
	Dough dough;
	Sauce sauce;
	
	public abstract void prepare();
	
	public void bake() {
		System.out.println("ִ�к濾����");
	}
	
	public void cut() {
		System.out.println("ִ���п�");
	}
	
	public void box() {
		System.out.println("ִ�д��");
	}
}
