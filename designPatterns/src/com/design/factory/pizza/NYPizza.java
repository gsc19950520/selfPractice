package com.design.factory.pizza;

import com.design.factory.abstractFactory.PizzaIngredientFactory;

public class NYPizza extends Pizza{
	
	private PizzaIngredientFactory ingredientFactory;
	
	public NYPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {
		ingredientFactory.createClams();
		ingredientFactory.createDough();
		ingredientFactory.createSauce();
		System.out.println("准备纽约披萨材料");
	}

}
