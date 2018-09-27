package com.design.factory.abstractFactory;

import com.design.factory.ingredient.Clams;
import com.design.factory.ingredient.Dough;
import com.design.factory.ingredient.Sauce;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Dough createDough() {
		return new Dough();
	}

	@Override
	public Sauce createSauce() {
		return new Sauce();
	}

	@Override
	public Clams createClams() {
		return new Clams();
	}

}
