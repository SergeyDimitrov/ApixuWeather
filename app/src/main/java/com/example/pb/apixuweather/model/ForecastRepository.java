package com.example.pb.apixuweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class ForecastRepository {

    private UUID id;

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("current")
    @Expose
    private Current current;

    @SerializedName("forecast")
    @Expose
    private Forecast forecast;

    public ForecastRepository() {
        id = UUID.randomUUID();
    }

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

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ForecastRepository)) {
            return false;
        }
        ForecastRepository other = (ForecastRepository) obj;
        return id.equals(other.id);
    }
}