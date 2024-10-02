package com.hdalgorithm.weather_service.model.response;

import lombok.Data;
import java.util.List;

@Data
public class WeatherAlertResponse {
    private Alert alerts;

    @Data
    public static class Alert {
        private String headline;
        private String msgtype;
        private String severity;
        private String urgency;
        private String areas;
        private String category;
        private String certainty;
        private String event;
        private String note;
        private String effective;
        private String expires;
    }
}
