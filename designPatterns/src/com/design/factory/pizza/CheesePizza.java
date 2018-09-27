package com.design.factory.pizza;

import com.design.factory.abstractFactory.PizzaIngredientFactory;

public class CheesePizza extends Pizza{

	private PizzaIngredientFactory ingredientFactory;
	
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {
		ingredientFactory.createClams();
		ingredientFactory.createDough();
		ingredientFactory.createSauce();
		System.out.println("×¼±¸ÄÌÀÒÅûÈø²ÄÁÏ");
	}

}
