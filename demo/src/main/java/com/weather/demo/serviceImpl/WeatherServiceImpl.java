package com.weather.demo.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.demo.darksky.response.Daily;
import com.weather.demo.darksky.response.DarkSkyResponse;
import com.weather.demo.darksky.response.Datum__;
import com.weather.demo.response.WeatherResponse;
import com.weather.demo.service.DarkSkyService;
import com.weather.demo.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{

	
@Autowired 
DarkSkyService service;

	@Override
	public WeatherResponse getweatherResponse(double latt, double longi){


		DarkSkyResponse response = new DarkSkyResponse();
		
		try {

		response = service.getDarkSkyResponse(latt, longi, null);
		
		}catch(Exception e) {
			
			e.getMessage();
			
		}

		WeatherResponse res = new WeatherResponse();

		res.setDate(EoctoDate(response.getCurrently().getTime()));
		res.setTime(EpocTimetoTime(response.getCurrently().getTime()));
		res.setTemperature(response.getCurrently().getTemperature());

		Daily daily = response.getDaily();

		Datum__ data = daily.getData().get(0);

		res.setSunriseTime(EpocTimetoTime(data.getSunriseTime()));
		res.setSunsetTime(EpocTimetoTime(data.getSunsetTime()));
		res.setTemperatureHigh(data.getTemperatureHigh());
		res.setTemperatureHighTime(data.getTemperatureHighTime());
		res.setTemperatureLow(data.getTemperatureLow());
		res.setTemperatureLowTime(data.getTemperatureLowTime());
		

		return res;
	}

	@Override
	public WeatherResponse getLastweatherResponse(double latt, double longi, Long epoc) throws Exception {

		DarkSkyResponse response = new DarkSkyResponse();

		response = service.getDarkSkyResponse(latt, longi, epoc);

		WeatherResponse res = new WeatherResponse();

		res.setDate(EoctoDate(response.getCurrently().getTime()));
		res.setTime(EpocTimetoTime(response.getCurrently().getTime()));
		res.setTemperature(response.getCurrently().getTemperature());
		Daily daily = response.getDaily();

		Datum__ data = daily.getData().get(0);

		res.setSunriseTime(EpocTimetoTime(data.getSunriseTime()));
		res.setSunsetTime(EpocTimetoTime(data.getSunsetTime()));
		res.setTemperatureHigh(data.getTemperatureHigh());
		res.setTemperatureHighTime(data.getTemperatureHighTime());
		res.setTemperatureLow(data.getTemperatureLow());
		res.setTemperatureLowTime(data.getTemperatureLowTime());

		return res;
	}
	
	private String EoctoDate(Long epocTime) {
		
		return new SimpleDateFormat("MM/dd/yyyy").format(new Date(epocTime * 1000));
		
		
	}
	
	private String EpocTimetoTime(Long epocTime) {
		
		return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date(epocTime * 1000));
		
	}

	
}
