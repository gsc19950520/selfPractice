package com.composite.step5;

import com.composite.step1.Duck;

public class PersonBean implements Observer {

	@Override
	public void update(Duck duck) {
		System.out.println("观察者，当前是鸭子：" + duck);
	}

}
