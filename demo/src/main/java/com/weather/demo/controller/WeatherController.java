package com.weather.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weather.demo.response.Response;
import com.weather.demo.response.WeatherResponse;
import com.weather.demo.service.WeatherService;




@RestController

public class WeatherController {

	@Autowired
	WeatherService service;

	@RequestMapping(value = "/weather/{latt}/{longi}", method = RequestMethod.GET)
	Response getEmployee(@PathVariable double latt, @PathVariable double longi) throws Exception {

		Response response = new Response();

		List<WeatherResponse> wResponses = new ArrayList<WeatherResponse>();
		WeatherResponse wRes = new WeatherResponse();

		wRes = service.getweatherResponse(latt, longi);

		Long epoc = getEpocTime();
		
		WeatherResponse wRes1 = new WeatherResponse();
		wRes1 = service.getLastweatherResponse(latt, longi, epoc);
		wResponses.add(wRes);
		wResponses.add(wRes1);

		response.setResponse(wResponses);

		return response;

	}
	
	public long getEpocTime() throws ParseException {
		
		
		Calendar lastyear = Calendar.getInstance();
		
		lastyear.add(Calendar.YEAR, -1);
		
		Date time = lastyear.getTime();
		
		SimpleDateFormat simpledate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		
		String s = simpledate.format(time);
		
		return new SimpleDateFormat("MM/dd/yyy HH:MM:ss").parse(s).getTime() / 1000;
		
	}

}
