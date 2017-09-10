package com.example.pb.apixuweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastHour {

    @SerializedName("time_epoch")
    @Expose
    private int timeEpoch;

    @SerializedName("time")
    @Expose
    private String time;

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

    @SerializedName("windchill_c")
    @Expose
    private double windchillC;

    @SerializedName("windchill_f")
    @Expose
    private double windchillF;

    @SerializedName("heatindex_c")
    @Expose
    private double heatindexC;

    @SerializedName("heatindex_f")
    @Expose
    private double heatindexF;

    @SerializedName("dewpoint_c")
    @Expose
    private double dewpointC;

    @SerializedName("dewpoint_f")
    @Expose
    private double dewpointF;

    @SerializedName("will_it_rain")
    @Expose
    private int willItRain;

    @SerializedName("will_it_snow")
    @Expose
    private int willItSnow;

    @SerializedName("vis_km")
    @Expose
    private double visKm;

    @SerializedName("vis_miles")
    @Expose
    private double visMiles;

    public int getTimeEpoch() {
        return timeEpoch;
    }

    public String getTime() {
        return time;
    }

    public String getHourTime() {
        return time.substring(time.length() - 5);
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

    public double getWindchillC() {
        return windchillC;
    }

    public double getWindchillF() {
        return windchillF;
    }

    public double getHeatindexC() {
        return heatindexC;
    }

    public double getHeatindexF() {
        return heatindexF;
    }

    public double getDewpointC() {
        return dewpointC;
    }

    public double getDewpointF() {
        return dewpointF;
    }

    public int getWillItRain() {
        return willItRain;
    }

    public int getWillItSnow() {
        return willItSnow;
    }

    public double getVisKm() {
        return visKm;
    }

    public double getVisMiles() {
        return visMiles;
    }
}
