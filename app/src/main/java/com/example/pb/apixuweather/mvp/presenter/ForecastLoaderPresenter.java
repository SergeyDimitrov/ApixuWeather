package com.example.pb.apixuweather.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.pb.apixuweather.application.ApixuApi;
import com.example.pb.apixuweather.application.ApixuWeatherApplication;
import com.example.pb.apixuweather.model.ForecastRepository;
import com.example.pb.apixuweather.mvp.view.ForecastLoaderView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class ForecastLoaderPresenter extends MvpPresenter<ForecastLoaderView> {

    @Inject
    ApixuApi apixuApi;

    private Call<ForecastRepository> call;

    public ForecastLoaderPresenter() {
        ApixuWeatherApplication.getApplicationComponent().inject(this);
    }

    public void startLoading() {
        if (call != null) {
            return;
        }
        getViewState().showProgress();
        call = apixuApi.loadForecast(ApixuApi.API_KEY, ApixuApi.CITY_REQUEST, ApixuApi.DAYS_NUMBER_REQUEST);
        call.enqueue(new Callback<ForecastRepository>() {
            @Override
            public void onResponse(Call<ForecastRepository> call, Response<ForecastRepository> response) {
                if (response == null) {
                    getViewState().setForecastRepository(null);
                    getViewState().hideProgress();
                } else {
                    getViewState().setForecastRepository(response.body());
                    getViewState().hideProgress();
                }
            }

            @Override
            public void onFailure(Call<ForecastRepository> call, Throwable t) {
                getViewState().setForecastRepository(null);
                getViewState().hideProgress();
            }
        });
    }
}
