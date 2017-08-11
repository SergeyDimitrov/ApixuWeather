package com.example.pb.apixuweather.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastRepository {

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("current")
    @Expose
    private Current current;

    @SerializedName("forecast")
    @Expose
    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public int getItemsCount() {
        return forecast.getForecastDay().size();
    }
}