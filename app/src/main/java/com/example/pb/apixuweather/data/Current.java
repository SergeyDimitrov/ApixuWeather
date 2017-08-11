package com.example.pb.apixuweather.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("last_updated_epoch")
    @Expose
    private int lastUpdatedEpoch;

    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;

    @SerializedName("temp_c")
    @Expose
    private double tempC;

    @SerializedName("temp_f")
    @Expose
    private double tempF;

    @SerializedName("is_day")
    @Expose
    private int isDay;

    @SerializedName("condition")
    @Expose
    private Condition condition;

    @SerializedName("wind_mph")
    @Expose
    private double windMph;

    @SerializedName("wind_kph")
    @Expose
    private double windKph;

    @SerializedName("wind_degree")
    @Expose
    private int windDegree;

    @SerializedName("wind_dir")
    @Expose
    private String windDir;

    @SerializedName("pressure_mb")
    @Expose
    private double pressureMb;

    @SerializedName("pressure_in")
    @Expose
    private double pressureIn;

    @SerializedName("precip_mm")
    @Expose
    private double precipMm;

    @SerializedName("precip_in")
    @Expose
    private double precipIn;

    @SerializedName("humidity")
    @Expose
    private int humidity;

    @SerializedName("cloud")
    @Expose
    private int cloud;

    @SerializedName("feelslike_c")
    @Expose
    private double feelslikeC;

    @SerializedName("feelslike_f")
    @Expose
    private double feelslikeF;

    @SerializedName("vis_km")
    @Expose
    private double visKm;

    @SerializedName("vis_miles")
    @Expose
    private double visMiles;

    public int getLastUpdatedEpoch() {
        return lastUpdatedEpoch;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public double getTempC() {
        return tempC;
    }

    public double getTempF() {
        return tempF;
    }

    public int getIsDay() {
        return isDay;
    }

    public Condition getCondition() {
        return condition;
    }

    public double getWindMph() {
        return windMph;
    }

    public double getWindKph() {
        return windKph;
    }

    public int getWindDegree() {
        return windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public double getPressureMb() {
        return pressureMb;
    }

    public double getPressureIn() {
        return pressureIn;
    }

    public double getPrecipMm() {
        return precipMm;
    }

    public double getPrecipIn() {
        return precipIn;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }

    public double getFeelslikeF() {
        return feelslikeF;
    }

    public double getVisKm() {
        return visKm;
    }

    public double getVisMiles() {
        return visMiles;
    }
}
