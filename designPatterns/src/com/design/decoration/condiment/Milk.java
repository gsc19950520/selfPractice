package com.design.decoration.condiment;

import com.design.decoration.Beverage;

public class Milk extends CondimentDecoration{

	private Beverage beverage;
	
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + "£¬¼ÓÈëÅ£ÄÌ";
	}

	@Override
	public double cost() {
		return beverage.cost() + 20.99;
	}

}
