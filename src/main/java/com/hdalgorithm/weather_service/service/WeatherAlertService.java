package com.hdalgorithm.weather_service.service;

import com.hdalgorithm.weather_service.model.response.WeatherAlertResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherAlertService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherAlertService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherAlertResponse getAlertsForLocation(String location) {
        String apiUrl = "http://api.weatherapi.com/v1/forecast.json?key=" + apiKey + "&q=" + location + "&alerts=yes";
        return restTemplate.getForObject(apiUrl, WeatherAlertResponse.class);
    }
}
