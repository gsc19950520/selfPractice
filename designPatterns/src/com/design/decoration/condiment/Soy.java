package com.design.decoration.condiment;

import com.design.decoration.Beverage;

public class Soy extends CondimentDecoration{

	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + "£¨º”»Î¥Û∂π";
	}

	@Override
	public double cost() {
		return beverage.cost() + 10.99;
	}

}
