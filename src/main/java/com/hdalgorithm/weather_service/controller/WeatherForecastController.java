package com.hdalgorithm.weather_service.controller;

import com.hdalgorithm.weather_service.model.response.WeatherForecastResponse;
import com.hdalgorithm.weather_service.service.WeatherForecastService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WeatherForecastController {

    private final WeatherForecastService weatherForecastService;

    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/weather/forecast")
    public WeatherForecastResponse getWeatherForecast(@RequestParam String location, @RequestParam int days) {
        return weatherForecastService.getForecastForLocation(location, days);
    }
}