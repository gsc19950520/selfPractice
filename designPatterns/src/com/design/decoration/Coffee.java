package com.design.decoration;

public class Coffee extends Beverage{

	@Override
	public String getDescription() {
		return "��������";
	}

	@Override
	public double cost() {
		return 29.99;
	}

}
