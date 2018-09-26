package com.design.observer.subject;

import com.design.observer.Observer;

public interface Observable {

	void notifyAllObservers();
	
	void registerObserver(Observer observer);
	
	void removeObserver(Observer observer);
}
