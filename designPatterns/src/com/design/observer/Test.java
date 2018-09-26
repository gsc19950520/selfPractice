package com.design.observer;

import com.design.observer.subject.WeatherData;

public class Test {

	public static void main(String[] args) {
		WeatherData subject = new WeatherData();
		
		Observer observer1 = new Display1();
		Observer observer2 = new Display2();
		Observer observer3 = new Display3();
		
		subject.registerObserver(observer1);
		subject.registerObserver(observer3);
		subject.registerObserver(observer2);
		subject.change("ºÚÒ¹", 10);
		
		subject.removeObserver(observer2);
		subject.change("°×Ìì", 30);
	}
}
