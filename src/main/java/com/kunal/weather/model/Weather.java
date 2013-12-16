package com.kunal.weather.model;

/**
 * Model Class for Weather information
 * @author kunal dhande
 *
 */
public class Weather {
	String zipCode;
	String weather;
	String place;
	String temperature;
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public void printObject(){
		System.out.println("zipCode:"+zipCode+", place"+place+", weather"+weather+", temperature"+temperature);
		
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
}

