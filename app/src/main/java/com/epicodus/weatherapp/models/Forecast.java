package com.epicodus.weatherapp.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 10/17/17.
 */

@Parcel
public class Forecast {
    public double minTemp;
    public double maxTemp;
    public double pressure;
    public double humidity;
    public String description;
    public String iconIndex;

    public Forecast() {

    }

    public Forecast(double minTemp, double maxTemp, double pressure, double humidity, String description, String iconIndex) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.description = description;
        this.iconIndex = iconIndex;
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

    public String getIconIndex() {
        return iconIndex;
    }
}
