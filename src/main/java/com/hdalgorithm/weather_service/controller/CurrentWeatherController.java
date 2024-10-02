package com.hdalgorithm.weather_service.controller;

import com.hdalgorithm.weather_service.model.response.CurrentWeatherResponse;
import com.hdalgorithm.weather_service.service.CurrentWeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CurrentWeatherController {

    private final CurrentWeatherService currentWeatherService;

    public CurrentWeatherController(CurrentWeatherService currentWeatherService) {
        this.currentWeatherService = currentWeatherService;
    }

    @GetMapping("/weather/current")
    public CurrentWeatherResponse getCurrentWeather(@RequestParam String location) {
        return currentWeatherService.getWeatherForLocation(location);
    }
}
