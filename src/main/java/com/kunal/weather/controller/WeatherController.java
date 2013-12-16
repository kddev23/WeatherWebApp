package com.kunal.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.kunal.weather.model.Weather;
import com.kunal.weather.validator.WeatherValidator;


@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	WeatherValidator weatherValidator;
	 
	@Autowired
	public WeatherController(WeatherValidator weatherValidator){
		this.weatherValidator = weatherValidator;
	}
 
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("weather") Weather weather,
		BindingResult result, SessionStatus status) {
		
		weatherValidator.validate(weather, result);
		if (result.hasErrors()) {
			//if validator failed
			return "WeatherForm";
		} else {
			status.setComplete();
			//form success
			return "WeatherForm";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){
		Weather weather = new Weather();
		//command object
		model.addAttribute("weather", weather);
		//return form view
		return "WeatherForm";
	}
}
