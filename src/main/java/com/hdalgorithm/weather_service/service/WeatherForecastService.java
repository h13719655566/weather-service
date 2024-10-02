package com.hdalgorithm.weather_service.service;

import com.hdalgorithm.weather_service.model.response.WeatherForecastResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherForecastService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherForecastService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherForecastResponse getForecastForLocation(String location, int days) {
        String apiUrl = "http://api.weatherapi.com/v1/forecast.json?key=" + apiKey + "&q=" + location + "&days=" + days;
        return restTemplate.getForObject(apiUrl, WeatherForecastResponse.class);
    }
}