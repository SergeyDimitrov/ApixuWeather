package com.example.pb.apixuweather.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Astro implements Parcelable {

    @SerializedName("sunrise")
    @Expose
    private String sunrise;

    @SerializedName("sunset")
    @Expose
    private String sunset;

    @SerializedName("moonrise")
    @Expose
    private String moonrise;

    @SerializedName("moonset")
    @Expose
    private String moonset;

    protected Astro(Parcel in) {
        sunrise = in.readString();
        sunset = in.readString();
        moonrise = in.readString();
        moonset = in.readString();
    }

    public static final Creator<Astro> CREATOR = new Creator<Astro>() {
        @Override
        public Astro createFromParcel(Parcel in) {
            return new Astro(in);
        }

        @Override
        public Astro[] newArray(int size) {
            return new Astro[size];
        }
    };

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(sunrise);
        parcel.writeString(sunset);
        parcel.writeString(moonrise);
        parcel.writeString(moonset);
    }
}
