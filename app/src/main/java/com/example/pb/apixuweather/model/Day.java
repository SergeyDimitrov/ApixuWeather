package com.example.pb.apixuweather.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day implements Parcelable {

    @SerializedName("maxtemp_c")
    @Expose
    private double maxtempC;

    @SerializedName("maxtemp_f")
    @Expose
    private double maxtempF;

    @SerializedName("mintemp_c")
    @Expose
    private double mintempC;

    @SerializedName("mintemp_f")
    @Expose
    private double mintempF;

    @SerializedName("avgtemp_c")
    @Expose
    private double avgtempC;

    @SerializedName("avgtemp_f")
    @Expose
    private double avgtempF;

    @SerializedName("maxwind_mph")
    @Expose
    private double maxwindMph;

    @SerializedName("maxwind_kph")
    @Expose
    private double maxwindKph;

    @SerializedName("totalprecip_mm")
    @Expose
    private double totalprecipMm;

    @SerializedName("totalprecip_in")
    @Expose
    private double totalprecipIn;

    @SerializedName("avgvis_km")
    @Expose
    private double avgvisKm;

    @SerializedName("avgvis_miles")
    @Expose
    private double avgvisMiles;

    @SerializedName("avghumidity")
    @Expose
    private double avghumidity;

    @SerializedName("condition")
    @Expose
    private Condition condition;

    protected Day(Parcel in) {
        maxtempC = in.readDouble();
        maxtempF = in.readDouble();
        mintempC = in.readDouble();
        mintempF = in.readDouble();
        avgtempC = in.readDouble();
        avgtempF = in.readDouble();
        maxwindMph = in.readDouble();
        maxwindKph = in.readDouble();
        totalprecipMm = in.readDouble();
        totalprecipIn = in.readDouble();
        avgvisKm = in.readDouble();
        avgvisMiles = in.readDouble();
        avghumidity = in.readDouble();
        condition = in.readParcelable(Condition.class.getClassLoader());
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

    public double getMaxtempC() {
        return maxtempC;
    }

    public double getMaxtempF() {
        return maxtempF;
    }

    public double getMintempC() {
        return mintempC;
    }

    public double getMintempF() {
        return mintempF;
    }

    public double getAvgtempC() {
        return avgtempC;
    }

    public double getAvgtempF() {
        return avgtempF;
    }

    public double getMaxwindMph() {
        return maxwindMph;
    }

    public double getMaxwindKph() {
        return maxwindKph;
    }

    public double getTotalprecipMm() {
        return totalprecipMm;
    }

    public double getTotalprecipIn() {
        return totalprecipIn;
    }

    public double getAvgvisKm() {
        return avgvisKm;
    }

    public double getAvgvisMiles() {
        return avgvisMiles;
    }

    public double getAvghumidity() {
        return avghumidity;
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(maxtempC);
        parcel.writeDouble(maxtempF);
        parcel.writeDouble(mintempC);
        parcel.writeDouble(mintempF);
        parcel.writeDouble(avgtempC);
        parcel.writeDouble(avgtempF);
        parcel.writeDouble(maxwindMph);
        parcel.writeDouble(maxwindKph);
        parcel.writeDouble(totalprecipMm);
        parcel.writeDouble(totalprecipIn);
        parcel.writeDouble(avgvisKm);
        parcel.writeDouble(avgvisMiles);
        parcel.writeDouble(avghumidity);
        parcel.writeParcelable(condition, i);
    }
}