package com.example.pb.apixuweather.application;

import android.app.Application;
import android.content.Context;

import com.example.pb.apixuweather.di.DaggerApplicationComponent;
import com.example.pb.apixuweather.di.module.ContextModule;
import com.example.pb.apixuweather.di.ApplicationComponent;
import com.example.pb.apixuweather.di.module.NetworkModule;

public class ApixuWeatherApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static ApixuWeatherApplication get(Context context) {
        return (ApixuWeatherApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
