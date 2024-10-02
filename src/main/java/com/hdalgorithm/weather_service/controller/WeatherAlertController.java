package com.hdalgorithm.weather_service.controller;

import com.hdalgorithm.weather_service.model.response.WeatherAlertResponse;
import com.hdalgorithm.weather_service.service.WeatherAlertService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WeatherAlertController {

    private final WeatherAlertService weatherAlertService;

    public WeatherAlertController(WeatherAlertService weatherAlertService) {
        this.weatherAlertService = weatherAlertService;
    }

    @GetMapping("/weather/alerts")
    public WeatherAlertResponse getWeatherAlerts(@RequestParam String location) {
        return weatherAlertService.getAlertsForLocation(location);
    }
}
