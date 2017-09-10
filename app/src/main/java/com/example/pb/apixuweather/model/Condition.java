package com.example.pb.apixuweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Condition {

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("code")
    @Expose
    private int code;

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }

    public int getCode() {
        return code;
    }
}
