package com.design.observer.subject;

import java.util.ArrayList;
import java.util.List;

import com.design.observer.Observer;

public class WeatherData implements Observable{

	private String weather;
	private int humidity;
	List<Observer> observers;
	
	public WeatherData() {
		observers = new ArrayList<>();
	}
	
	
	public void change(String weather, int humidity) {
		this.humidity = humidity;
		this.weather = weather;
		notifyAllObservers();
	}

	@Override
	public void notifyAllObservers() {
		for(Observer o : observers) {
			o.update(this);
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

	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
}
