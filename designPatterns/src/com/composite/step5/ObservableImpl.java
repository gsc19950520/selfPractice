package com.composite.step5;

import java.util.ArrayList;
import java.util.List;

import com.composite.step1.Duck;


public class ObservableImpl implements Observable{
	
	private List<Observer> observers;
	
	public ObservableImpl() {
		observers = new ArrayList<>();
	}

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
