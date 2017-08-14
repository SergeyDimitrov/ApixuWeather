package com.example.pb.apixuweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {

    @SerializedName("forecastday")
    @Expose
    private List<ForecastDay> forecastDay;

    public List<ForecastDay> getForecastDay() {
        return forecastDay;
    }
}
