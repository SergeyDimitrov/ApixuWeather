package com.example.pb.apixuweather;

import com.example.pb.apixuweather.network.NetworkModule;
import com.example.pb.apixuweather.ui.fragment.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ApplicationModule.class})
public interface MainComponent {
    void inject(MainFragment mainFragment);
}
