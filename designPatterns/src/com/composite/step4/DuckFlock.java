package com.composite.step4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.composite.step1.Duck;

public class DuckFlock extends Duck{

	private List<Duck> ducks;
	
	public DuckFlock() {
		ducks = new ArrayList<>();
	}
	
//	public DuckFlock(Observable observable) {
//		ducks = new ArrayList<>();
//		this.observable = observable;
//	}
	
	public void addDuck(Duck duck) {
		ducks.add(duck);
	}

	@Override
	public void quack() {
		Iterator<Duck> iterator = ducks.iterator();
		while(iterator.hasNext()) {
			Duck duck = iterator.next();
			duck.quack();
			if(!(duck instanceof DuckFlock)) {
				notifyAllObserver(duck);
			}
		}
	}
}
