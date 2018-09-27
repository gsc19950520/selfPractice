package com.design.decoration;

import com.design.decoration.condiment.Milk;
import com.design.decoration.condiment.Mocha;
import com.design.decoration.condiment.Soy;

public class Test {

	public static void main(String[] args) {
		Beverage coffee = new Coffee();
		Beverage condiment1 = new Mocha(coffee);
		Beverage condiment2 = new Soy(condiment1);
		Beverage condiment3 = new Milk(condiment2);
		
		System.out.println(condiment3.getDescription() + "£¬  ×Ü¼ÛÎª£º" + condiment3.cost());
	}
}
