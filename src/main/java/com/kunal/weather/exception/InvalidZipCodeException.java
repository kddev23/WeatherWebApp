package com.kunal.weather.exception;

/**
 * Exception class to handle invalid zip code error
 * @author kunal dhande
 *
 */
public class InvalidZipCodeException extends RuntimeException {
	 public InvalidZipCodeException(String s) {
	        super(s);
	 }
}
