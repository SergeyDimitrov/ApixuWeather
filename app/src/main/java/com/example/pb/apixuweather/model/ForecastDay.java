package com.example.pb.apixuweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.UUID;

public class ForecastDay {
    
    private UUID id;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("date_epoch")
    @Expose
    private int dateEpoch;

    @SerializedName("day")
    @Expose
    private Day day;

    @SerializedName("astro")
    @Expose
    private Astro astro;

    @SerializedName("hour")
    @Expose
    private List<ForecastHour> hour;

    public ForecastDay() {
        id = UUID.randomUUID();
    }

    public String getDate() {
        return date;
    }

    public int getDateEpoch() {
        return dateEpoch;
    }

    public Day getDay() {
        return day;
    }

    public Astro getAstro() {
        return astro;
    }

    public List<ForecastHour> getHour() {
        return hour;
    }

    public UUID getId() {
        return id;
    }
}
