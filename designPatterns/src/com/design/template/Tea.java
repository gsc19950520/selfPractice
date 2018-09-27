package com.design.template;

public class Tea extends Beverage{

	@Override
	public void addToBeverage() {
		System.out.println("用水冲泡茶");
	}

	@Override
	public void addCondiment() {
		System.out.println("加茶所需的调料");
	}

}
