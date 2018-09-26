package com.design.observer;

import com.design.observer.subject.WeatherData;

public interface Observer {

	void update(WeatherData weatherData);
}
