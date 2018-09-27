package com.design.template;

public class Test {

	public static void main(String[] args) {
		Beverage b = new Coffee();
		Beverage b2 = new Tea();
		
		b.prepare();
		System.out.println("----------------------------------------------");
		b2.prepare();
	}
}
