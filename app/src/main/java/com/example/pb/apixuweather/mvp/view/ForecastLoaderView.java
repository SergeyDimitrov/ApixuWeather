package com.example.pb.apixuweather.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.pb.apixuweather.model.ForecastRepository;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ForecastLoaderView extends MvpView {

    void setForecastRepository(ForecastRepository forecastRepository);

    void showProgress();

    void hideProgress();
}
