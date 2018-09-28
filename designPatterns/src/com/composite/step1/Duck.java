package com.composite.step1;

import java.util.ArrayList;
import java.util.List;

import com.composite.step5.Observable;
import com.composite.step5.Observer;

public abstract class Duck implements Observable{
	
//	public Observable observable;

	private List<Observer> observers;
	
	public Duck() {
		observers = new ArrayList<>();
	}

	public abstract void quack();
	
	@Override
	public void notifyAllObserver(Duck duck) {
		for(Observer observer : observers) {
			observer.update(duck);
		}
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
}
