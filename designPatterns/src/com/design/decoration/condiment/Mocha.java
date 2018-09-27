package com.design.decoration.condiment;

import com.design.decoration.Beverage;

public class Mocha extends CondimentDecoration{
	
	private Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + "£¬¼ÓÈëÄ¦¿¨";
	}

	@Override
	public double cost() {
		return beverage.cost() + 10.99;
	}

}
