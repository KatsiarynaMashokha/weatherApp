package com.epicodus.weatherapp;

/**
 * Created by Guest on 10/17/17.
 */

public class Forecast {
    private double minTemp;
    private double maxTemp;
    private double pressure;
    private double humidity;
    private String description;
    private String iconUrl;

    public Forecast(double minTemp, double maxTemp, double pressure, double humidity, String description, String iconUrl) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.description = description;
        this.iconUrl = iconUrl;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
