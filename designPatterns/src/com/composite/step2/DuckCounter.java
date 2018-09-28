package com.composite.step2;

import com.composite.step1.Duck;

public class DuckCounter extends Duck {
	
	private static int count;
	private Duck duck;
	
	public DuckCounter(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void quack() {
		duck.quack();
		count++;
	}
	
	public static int getCount() {
		return count;
	}


}
