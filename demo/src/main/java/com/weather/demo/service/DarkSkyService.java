package com.weather.demo.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.weather.demo.darksky.response.DarkSkyResponse;

@Service
public interface DarkSkyService {

	
	public abstract DarkSkyResponse getDarkSkyResponse(double latt, double longi, Long epoc) throws Exception;
	
}
