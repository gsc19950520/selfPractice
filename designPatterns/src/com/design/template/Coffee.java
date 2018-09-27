package com.design.template;

public class Coffee extends Beverage{

	@Override
	public void addToBeverage() {
		System.out.println("用水冲泡咖啡");
	}

	@Override
	public void addCondiment() {
		System.out.println("加咖啡所需的调料");
	}

	@Override
	public boolean hook() {
		return true;
	}
}
