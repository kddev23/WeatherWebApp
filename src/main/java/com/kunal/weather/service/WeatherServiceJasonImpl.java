package com.kunal.weather.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.kunal.weather.model.Weather;

/**
 * Implementation class to access web API, parsed Jason response & build weather model
 * @author kunal dhande
 *
 */
public class WeatherServiceJasonImpl implements WeatherService{
	
	public Weather getWeatherCondition(Weather weather){
		HttpURLConnection conn = null;
		try 
		{
			URL url = new URL("http://api.wunderground.com/api/ed044d75b91fb500/conditions/q/"+weather.getZipCode()+".json");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String outputJasonString = "";;
			String output = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				outputJasonString = outputJasonString + output;
			}
			//System.out.println(outputJasonString);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(outputJasonString);
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject jsonObjectRes = (JSONObject) jsonObject.get("response");
			//System.out.println(jsonObjectRes);
			JSONObject jsonObjectError = (JSONObject) jsonObjectRes.get("error");
			if(jsonObjectError!=null){
				weather.setWeather("ZipCode not found!");
				System.out.println("error-"+jsonObjectError);
			}else{
				JSONObject jsonObjCurrentObservation = (JSONObject) jsonObject.get("current_observation");
				String jsonObjWeather = (String) jsonObjCurrentObservation.get("weather");
				JSONObject jsonObjLocation = (JSONObject) jsonObjCurrentObservation.get("display_location");
				String jsonObjFullLocation = (String) jsonObjLocation.get("full");
				String jsonObjCountry = (String) jsonObjLocation.get("country");
				String jsonObjTemp = (String) jsonObjCurrentObservation.get("temperature_string");
				System.out.println("weather-"+jsonObjWeather);
				weather.setPlace(jsonObjFullLocation);
				weather.setWeather(jsonObjWeather);
				weather.setTemperature(jsonObjTemp);
			}
			conn.disconnect();
	      } catch (MalformedURLException e) {
	    	weather.setWeather("We encounter some unexpected error. Please report error to Administrator using error code-101011.");
			System.out.println("Error While Connecting to Weather URL"+e.getMessage());
		  } catch (IOException e) {
			System.out.println("Error While Connecting to Weather URL"+e.getMessage());
			weather.setWeather("We encounter some unexpected error. Please report error to Administrator using error code-101012.");
		  }catch (Exception e) {
			System.out.println("Error While Connecting to Weather URL"+e.getMessage());
			weather.setWeather("We encounter some unexpected error. Please report error to Administrator using error code-101013.");
			e.printStackTrace();
		  }finally{
			  if(conn!=null)
				  conn.disconnect();
		  }
		return weather;
	}
}
