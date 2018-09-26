package com.design.strategy;

public class Test {

	public static void main(String[] args) {
		Duck duck1 = new BlackDuck();
		duck1.fly();
		duck1.quack();
		
		Duck duck2 = new RedDuck();
		duck2.fly();
		duck2.quack();
	}
}
