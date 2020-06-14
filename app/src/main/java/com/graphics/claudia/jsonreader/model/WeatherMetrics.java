package com.graphics.claudia.jsonreader.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.math.RoundingMode;

class WeatherMetrics {

    @SerializedName("temp")
    private double temp;

    @SerializedName("feels_like")
    private double feelsLike;

    @SerializedName("temp_min")
    private double minTemp;

    @SerializedName("temp_max")
    private double maxTemp;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("humidity")
    private double humidity;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public static int toCelsius(double kelvin) {
        Double conversion = new Double(kelvin - 273.15d);
        return conversion.intValue();
    }


    @Override
    public String toString() {
        return "\nTemp: " + toCelsius(temp) + "C" +
                "\nFeels like: " + toCelsius(feelsLike) + "C" +
                "\nMin Temp: " + toCelsius(minTemp) + "C" +
                "\nMax Temp: " + toCelsius(maxTemp) + "C" +
                "\nPressure: " + pressure +
                "\nHumidity: " + humidity;
    }
}
