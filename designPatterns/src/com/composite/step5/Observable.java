package com.composite.step5;

import com.composite.step1.Duck;

public interface Observable {

	void notifyAllObserver(Duck duck);
	
	void registerObserver(Observer observer);
	
	void removeObserver(Observer observer);
}
