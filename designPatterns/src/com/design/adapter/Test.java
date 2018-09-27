package com.design.adapter;

public class Test {

	public static void main(String[] args) {
		Duck d1 = new BlackDuck();
		Goose goose = new Goose();
		Duck d2 = new GooseAdapter(goose);
		
		d1.quack();
		d2.quack();
	}
}
