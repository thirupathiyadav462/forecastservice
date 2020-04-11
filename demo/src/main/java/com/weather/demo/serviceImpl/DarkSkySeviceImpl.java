package com.weather.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.demo.darksky.response.DarkSkyResponse;
import com.weather.demo.service.DarkSkyService;

@Service
public class DarkSkySeviceImpl implements DarkSkyService{

	
    @Autowired
    RestTemplate restTemplate;

    private String API_URL = "https://api.darksky.net/forecast/0b67f8f549800f7bdeccc85500ba9324/";

    public DarkSkyResponse getDarkSkyResponse(double latt, double longi, Long epoc) throws Exception
    {

    	String url = null;
    	if(epoc == null) {
    	url = API_URL+latt+","+longi;
    	}else {
    		 url = API_URL+latt+","+longi+","+epoc;
    	}

    	DarkSkyResponse response = new DarkSkyResponse();
    	try {
			try {
			response = restTemplate.getForObject(url, DarkSkyResponse.class);
			}
			catch(Exception e) {
				
				throw new Exception("something went wrong while fetching response from forecast API");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return response;
    }


}
