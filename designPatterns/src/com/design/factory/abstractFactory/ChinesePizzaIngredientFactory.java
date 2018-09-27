package com.design.factory.abstractFactory;

import com.design.factory.ingredient.Clams;
import com.design.factory.ingredient.Dough;
import com.design.factory.ingredient.Sauce;

public class ChinesePizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return null;
	}

	@Override
	public Sauce createSauce() {
		return new Sauce();
	}

	@Override
	public Clams createClams() {
		return null;
	}

}
