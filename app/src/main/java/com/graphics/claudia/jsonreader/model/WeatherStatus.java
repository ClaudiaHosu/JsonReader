package com.graphics.claudia.jsonreader.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherStatus {

    @SerializedName("weather")
    private List<Weather> wheatherReports = new ArrayList<>();

    @SerializedName("main")
    private WeatherMetrics weatherMetrics;

    public List<Weather> getWheatherReports() {
        return wheatherReports;
    }

    public void setWheatherReports(List<Weather> wheatherReports) {
        this.wheatherReports = wheatherReports;
    }

    public WeatherMetrics getWeatherMetrics() {
        return weatherMetrics;
    }

    public void setWeatherMetrics(WeatherMetrics weatherMetrics) {
        this.weatherMetrics = weatherMetrics;
    }

    @Override
    public String toString() {
        return wheatherReports.get(0).toString() + weatherMetrics.toString();
    }
}




