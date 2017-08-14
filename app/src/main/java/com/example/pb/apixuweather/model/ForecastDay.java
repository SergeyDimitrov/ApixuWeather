package com.example.pb.apixuweather.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastDay implements Parcelable {

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

    protected ForecastDay(Parcel in) {
        date = in.readString();
        dateEpoch = in.readInt();
        day = in.readParcelable(Day.class.getClassLoader());
        astro = in.readParcelable(Astro.class.getClassLoader());
    }

    public static final Creator<ForecastDay> CREATOR = new Creator<ForecastDay>() {
        @Override
        public ForecastDay createFromParcel(Parcel in) {
            return new ForecastDay(in);
        }

        @Override
        public ForecastDay[] newArray(int size) {
            return new ForecastDay[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
        parcel.writeInt(dateEpoch);
        parcel.writeParcelable(day, i);
        parcel.writeParcelable(astro, i);
        parcel.writeList(hour);
    }
}
