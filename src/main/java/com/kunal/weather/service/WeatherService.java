package com.kunal.weather.service;

import com.kunal.weather.model.Weather;

/**
 * Interface for WeatherService Client API
 * @author kunal dhande
 *
 */
public interface WeatherService {
	public Weather getWeatherCondition(Weather weather);
}
