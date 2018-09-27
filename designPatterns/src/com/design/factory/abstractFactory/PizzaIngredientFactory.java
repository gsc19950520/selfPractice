package com.design.factory.abstractFactory;

import com.design.factory.ingredient.Clams;
import com.design.factory.ingredient.Dough;
import com.design.factory.ingredient.Sauce;

public interface PizzaIngredientFactory {

	public Dough createDough();
	
	public Sauce createSauce();
	
	public Clams createClams();
}
