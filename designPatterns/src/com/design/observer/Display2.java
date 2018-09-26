package com.design.observer;

import com.design.observer.subject.WeatherData;

public class Display2 implements Observer , DisplayElement{

	private String weather;
	private int humidity;

	@Override
	public void update(WeatherData weatherData) {
//		this.weather = weatherData.getWeather();
		this.humidity = weatherData.getHumidity();
		display();
	}

	@Override
	public void display() {
		System.out.println("���ĺ��¶ȣ�" + this.humidity + "���ĺ�������"+this.weather);
	}

}
