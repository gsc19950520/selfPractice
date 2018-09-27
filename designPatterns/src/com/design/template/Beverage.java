package com.design.template;

public abstract class Beverage {

	public void prepare() {
		boil();
		addToBeverage();
		putCup();
		if(hook()) {
			addCondiment();
		}
	}
	
	public void boil() {
		System.out.println("把水煮沸");
	}
	
	public abstract void addToBeverage();
	public void putCup() {
		System.out.println("倒入杯子中");
	}
	
	public abstract void addCondiment();
	
	public boolean hook() {
		return false;
	}
}
