package com.hdalgorithm.weather_service.model.response;

import lombok.Data;
import java.util.List;

@Data
public class WeatherForecastResponse {
    private Location location;
    private Forecast forecast;

    @Data
    public static class Location {
        private String name;
        private String region;
        private String country;
        private double lat;
        private double lon;
    }

    @Data
    public static class Forecast {
        private List<ForecastDay> forecastday;

        @Data
        public static class ForecastDay {
            private String date;
            private Day day;

            @Data
            public static class Day {
                private double maxtemp_c;
                private double maxtemp_f;
                private double mintemp_c;
                private double mintemp_f;
                private double avgtemp_c;
                private double avgtemp_f;
                private double daily_chance_of_rain;
                private Condition condition;

                @Data
                public static class Condition {
                    private String text;
                    private String icon;
                }
            }
        }
    }
}