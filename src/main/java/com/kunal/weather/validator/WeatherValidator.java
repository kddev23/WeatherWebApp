package com.kunal.weather.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kunal.weather.model.Weather;
import com.kunal.weather.service.WeatherService;
import com.kunal.weather.service.WeatherServiceJasonImpl;

/**
 * Validator Class to validate ZipCode
 * @author kunal dhande
 *
 */
public class WeatherValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the Location instances
		return Weather.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Weather weather = (Weather)target;
		boolean isValidateSuccess = true;
		
		if(isValidateSuccess){
			if(weather.getZipCode()==null){
				errors.rejectValue("zipCode", "required.zipCode");
				isValidateSuccess = false;
			}else if("".equals(weather.getZipCode().trim())){
				errors.rejectValue("zipCode", "required.zipCode");
				isValidateSuccess = false;
			}
		}
		
		if(isValidateSuccess){
			if(weather.getZipCode().length()<5 || weather.getZipCode().length()>5){
				errors.rejectValue("zipCode", "invalidformat.zipCode");
				isValidateSuccess = false;
			}
		}
		if(isValidateSuccess){
			try
			 {
				Integer.parseInt(weather.getZipCode());
			 }
			 catch(Exception e)
			 {
				 errors.rejectValue("zipCode", "invalidformat.zipCode");
				 isValidateSuccess = false;
			 }
		}
		if(isValidateSuccess){
			WeatherService clientService = new WeatherServiceJasonImpl();
			weather = clientService.getWeatherCondition(weather);
		}
	}
	
}
