package com.example.pb.apixuweather.di;

import com.example.pb.apixuweather.di.module.ContextModule;
import com.example.pb.apixuweather.di.module.NetworkModule;
import com.example.pb.apixuweather.mvp.presenter.ForecastLoaderPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface ApplicationComponent {

    void inject(ForecastLoaderPresenter presenter);
}
