package com.design.factory.pizza;

import com.design.factory.abstractFactory.PizzaIngredientFactory;

public class ChichiPizza extends Pizza{

	private PizzaIngredientFactory ingredientFactory;
	
	public ChichiPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {
		ingredientFactory.createClams();
		ingredientFactory.createDough();
		ingredientFactory.createSauce();
		System.out.println("×¼±¸chichiÅûÈø²ÄÁÏ");
	}
}
