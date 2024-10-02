package com.hdalgorithm.weather_service.model.response;

import lombok.Data;

@Data
public class CurrentWeatherResponse {
    private Location location;
    private Current current;

    @Data
    public static class Location {
        private String name;
        private String region;
        private String country;
        private double lat;
        private double lon;
    }

    @Data
    public static class Current {
        private double temp_c;
        private double temp_f;
        private double humidity;
        private Condition condition;

        @Data
        public static class Condition {
            private String text;
            private String icon;
        }
    }
}