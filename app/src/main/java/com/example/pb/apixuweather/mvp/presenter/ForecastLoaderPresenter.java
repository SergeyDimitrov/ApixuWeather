package com.example.pb.apixuweather.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.pb.apixuweather.application.ApixuApi;
import com.example.pb.apixuweather.application.ApixuWeatherApplication;
import com.example.pb.apixuweather.mvp.view.ForecastLoaderView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ForecastLoaderPresenter extends MvpPresenter<ForecastLoaderView> {

    @Inject
    ApixuApi apixuApi;

    private Disposable forecastDisposable;

    public ForecastLoaderPresenter() {
        ApixuWeatherApplication.getApplicationComponent().inject(this);
    }

    public void startLoading() {
        getViewState().showProgress();
        forecastDisposable = apixuApi.loadForecast(ApixuApi.API_KEY, ApixuApi.CITY_REQUEST, ApixuApi.DAYS_NUMBER_REQUEST)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(forecastRepository -> {
                    getViewState().setForecastRepository(forecastRepository);
                    getViewState().hideProgress();
                }, throwable -> {
                    getViewState().setForecastRepository(null);
                    getViewState().hideProgress();
                });
    }
}
