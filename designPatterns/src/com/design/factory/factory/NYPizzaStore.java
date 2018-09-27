package com.design.factory.factory;

import com.design.factory.abstractFactory.PizzaIngredientFactory;
import com.design.factory.pizza.CheesePizza;
import com.design.factory.pizza.ChichiPizza;
import com.design.factory.pizza.NYPizza;
import com.design.factory.pizza.Pizza;

public class NYPizzaStore extends PizzaStore{
	
	private PizzaIngredientFactory ingredientFactory;
	
	public NYPizzaStore(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public Pizza createPizza(String type) {
		if(type.equals("NY")){
			return new NYPizza(ingredientFactory);
		}else if(type.equals("Chichi")) {
			return new ChichiPizza(ingredientFactory);
		}else if(type.equals("Cheese")) {
			return new CheesePizza(ingredientFactory);
		}else {
			System.out.println("不支持当前披萨的创建");
			return null;
		}
	}

}
