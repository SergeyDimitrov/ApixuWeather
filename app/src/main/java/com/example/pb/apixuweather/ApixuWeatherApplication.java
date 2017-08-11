package com.example.pb.apixuweather;

import android.app.Application;
import android.content.Context;

import com.example.pb.apixuweather.network.NetworkModule;


public class ApixuWeatherApplication extends Application {

    private MainComponent mainComponent;

    public static ApixuWeatherApplication get(Context context) {
        return (ApixuWeatherApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
