package com.design.decoration;

public class Tea extends Beverage{

	@Override
	public String getDescription() {
		return "ÖÆ×÷²è";
	}

	@Override
	public double cost() {
		return 59.99;
	}
}
