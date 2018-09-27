package com.design.factory;

import com.design.factory.abstractFactory.ChinesePizzaIngredientFactory;
import com.design.factory.abstractFactory.NYPizzaIngredientFactory;
import com.design.factory.abstractFactory.PizzaIngredientFactory;
import com.design.factory.factory.NYPizzaStore;
import com.design.factory.factory.PizzaStore;

public class Test {

	public static void main(String[] args) {
		PizzaIngredientFactory ingredient = new ChinesePizzaIngredientFactory();
		PizzaIngredientFactory ingredient2 = new NYPizzaIngredientFactory();
		PizzaStore factory = new NYPizzaStore(ingredient);
		PizzaStore factory2 = new NYPizzaStore(ingredient2);
		factory.orderPizza("Cheese");
		System.out.println("-------------------------------------------------");
		factory2.orderPizza("Cheese");
	}
}
