package com.design.strategy;

import com.design.strategy.behavior.DuckQuack;
import com.design.strategy.behavior.FarFly;
import com.design.strategy.behavior.FlyBehavior;
import com.design.strategy.behavior.QuackBehavior;

public class BlackDuck implements Duck {
	
	private FlyBehavior fly;
	private QuackBehavior quack;
	
	public BlackDuck() {
		fly = new FarFly();
		quack = new DuckQuack();
	}

	@Override
	public void fly() {
		fly.fly();
	}

	@Override
	public void quack() {
		quack.quack();
	}

}
