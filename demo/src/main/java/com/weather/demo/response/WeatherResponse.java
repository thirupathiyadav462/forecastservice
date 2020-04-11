package com.weather.demo.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
	
	 @JsonProperty("time")
	    private String time;
	    @JsonProperty("date")
	    private String date;
	    @JsonProperty("temperature")
	    private Double temperature;
	    @JsonProperty("sunriseTime")
	    private String sunriseTime;
	    @JsonProperty("sunsetTime")
	    private String sunsetTime;
	    @JsonProperty("temperatureHigh")
	    private Double temperatureHigh;
	    @JsonProperty("temperatureHighTime")
	    private Integer temperatureHighTime;
	    @JsonProperty("temperatureLow")
	    private Double temperatureLow;
	    @JsonProperty("temperatureLowTime")
	    private Integer temperatureLowTime;
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public Double getTemperature() {
			return temperature;
		}
		public void setTemperature(Double temperature) {
			this.temperature = temperature;
		}
		public String getSunriseTime() {
			return sunriseTime;
		}
		public void setSunriseTime(String sunriseTime) {
			this.sunriseTime = sunriseTime;
		}
		public String getSunsetTime() {
			return sunsetTime;
		}
		public void setSunsetTime(String sunsetTime) {
			this.sunsetTime = sunsetTime;
		}
		public Double getTemperatureHigh() {
			return temperatureHigh;
		}
		public void setTemperatureHigh(Double temperatureHigh) {
			this.temperatureHigh = temperatureHigh;
		}
		public Integer getTemperatureHighTime() {
			return temperatureHighTime;
		}
		public void setTemperatureHighTime(Integer temperatureHighTime) {
			this.temperatureHighTime = temperatureHighTime;
		}
		public Double getTemperatureLow() {
			return temperatureLow;
		}
		public void setTemperatureLow(Double temperatureLow) {
			this.temperatureLow = temperatureLow;
		}
		public Integer getTemperatureLowTime() {
			return temperatureLowTime;
		}
		public void setTemperatureLowTime(Integer temperatureLowTime) {
			this.temperatureLowTime = temperatureLowTime;
		}
	    
	
	    
}
