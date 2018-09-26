package com.design.strategy;

import com.design.strategy.behavior.DuckQuack;
import com.design.strategy.behavior.FarFly;
import com.design.strategy.behavior.FlyBehavior;
import com.design.strategy.behavior.GooseQuack;
import com.design.strategy.behavior.NoFly;
import com.design.strategy.behavior.QuackBehavior;

public class RedDuck implements Duck {
	
	private FlyBehavior fly;
	private QuackBehavior quack;
	
	public RedDuck() {
		fly = new NoFly();
		quack = new GooseQuack();
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
