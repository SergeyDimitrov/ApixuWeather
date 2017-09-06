package com.example.pb.apixuweather.utils;

import android.content.Context;

import com.example.pb.apixuweather.R;

public class TextFormatUtils {

    public static String getFormattedTemperature(Context context, double temperature) {
        return context.getResources().getString(R.string.temperature, temperature);
    }
}
