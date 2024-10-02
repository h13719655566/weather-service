
# Weather Microservice

This is a Weather Microservice built using Spring Boot, which provides weather information including current weather, weather forecast, and weather alerts for a specified location. The service integrates with WeatherAPI to fetch the weather data.

## Features

- **Current Weather Service**: Provides current weather information for a given location.
- **Weather Forecast Service**: Provides weather forecast for the next few days for a given location.
- **Weather Alert Service**: Provides weather alerts such as storm warnings, flood warnings, etc., for a given location.

## API Endpoints

### 1. Current Weather Service

- **Endpoint**: `/weather/current`
- **Method**: `GET`
- **Parameters**: 
  - `location` (required): The location for which you want to retrieve the current weather.
- **Example**: 
  ```
  GET /weather/current?location=Sydney
  ```
- **Response**:
  ```json
  {
      "location": {
          "name": "Sydney",
          "region": "New South Wales",
          "country": "Australia",
          "lat": -33.87,
          "lon": 151.21
      },
      "current": {
          "temp_c": 15.0,
          "temp_f": 59.0,
          "humidity": 82,
          "condition": {
              "text": "Partly cloudy",
              "icon": "//cdn.weatherapi.com/weather/64x64/day/116.png"
          }
      }
  }
  ```

### 2. Weather Forecast Service

- **Endpoint**: `/weather/forecast`
- **Method**: `GET`
- **Parameters**: 
  - `location` (required): The location for which you want to retrieve the weather forecast.
  - `days` (required): The number of days for the forecast (up to 7 days).
- **Example**:
  ```
  GET /weather/forecast?location=Sydney&days=3
  ```
- **Response**:
  ```json
  {
      "location": {
          "name": "Sydney",
          "region": "New South Wales",
          "country": "Australia",
          "lat": -33.87,
          "lon": 151.21
      },
      "forecast": {
          "forecastday": [
              {
                  "date": "2024-08-20",
                  "day": {
                      "maxtemp_c": 21.0,
                      "mintemp_c": 14.0,
                      "condition": {
                          "text": "Sunny",
                          "icon": "//cdn.weatherapi.com/weather/64x64/day/113.png"
                      }
                  }
              }
          ]
      }
  }
  ```

### 3. Weather Alert Service

- **Endpoint**: `/weather/alerts`
- **Method**: `GET`
- **Parameters**: 
  - `location` (required): The location for which you want to retrieve weather alerts.
- **Example**:
  ```
  GET /weather/alerts?location=Sydney
  ```
- **Response**:
  ```json
  {
      "alerts": {
          "headline": null,
          "msgtype": null,
          "severity": null,
          "urgency": null,
          "areas": null,
          "category": null,
          "certainty": null,
          "event": null,
          "note": null,
          "effective": null,
          "expires": null
      }
  }
  ```

## Setup Instructions

### Prerequisites

- Java 17
- Maven 3.6.0 or higher
- WeatherAPI Account and API Key (you can register at [WeatherAPI](https://www.weatherapi.com/))

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/weather-service.git
   cd weather-service
   ```

2. Set up your WeatherAPI key in `src/main/resources/application.properties`:
   ```properties
   weather.api.key=YOUR_WEATHERAPI_KEY
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Project Structure

- `src/main/java/com/example/weather/current`: Contains the Current Weather Service implementation.
- `src/main/java/com/example/weather/forecast`: Contains the Weather Forecast Service implementation.
- `src/main/java/com/example/weather/alerts`: Contains the Weather Alert Service implementation.
- `src/main/resources`: Contains the application configuration files.
