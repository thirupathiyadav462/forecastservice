package com.weather.demo.service;

import org.springframework.stereotype.Service;

import com.weather.demo.response.WeatherResponse;

@Service
public interface WeatherService {


	 public abstract  WeatherResponse getweatherResponse(double latt, double longi);
	 public abstract  WeatherResponse getLastweatherResponse(double latt, double longi, Long ep) throws Exception;
	
	    
}
