package com.hdalgorithm.weather_service.service;

import com.hdalgorithm.weather_service.model.response.CurrentWeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrentWeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public CurrentWeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrentWeatherResponse getWeatherForLocation(String location) {
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location;
        return restTemplate.getForObject(apiUrl, CurrentWeatherResponse.class);
    }
}