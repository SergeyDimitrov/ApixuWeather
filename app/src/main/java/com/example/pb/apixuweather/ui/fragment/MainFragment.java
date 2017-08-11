package com.example.pb.apixuweather.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pb.apixuweather.ApixuWeatherApplication;
import com.example.pb.apixuweather.R;
import com.example.pb.apixuweather.data.ForecastDay;
import com.example.pb.apixuweather.data.ForecastRepository;
import com.example.pb.apixuweather.network.ApixuApi;
import com.example.pb.apixuweather.ui.activity.DetailsActivity;
import com.example.pb.apixuweather.ui.adapter.ForecastAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends BaseFragment implements Callback<ForecastRepository> {

    @BindView(R.id.main_forecast_list) RecyclerView forecastList;

    private ForecastAdapter forecastAdapter;
    private Call<ForecastRepository> call;

    @Inject ApixuApi apixuApi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApixuWeatherApplication.get(getContext()).getMainComponent().inject(this);
        forecastAdapter = new ForecastAdapter(getContext());
        forecastAdapter.setListener(new ForecastAdapter.OnForecastItemClickListener() {
            @Override
            public void OnForecastItemClick(ForecastDay forecastDay) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra(DetailsFragment.FORECAST_DAY_KEY, forecastDay);
                startActivity(intent);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        forecastList.setAdapter(forecastAdapter);
        forecastList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onStart() {
        super.onStart();
        call = apixuApi.loadForecast(ApixuApi.API_KEY, ApixuApi.CITY_REQUEST, ApixuApi.DAYS_NUMBER_REQUEST);
        call.enqueue(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (call != null) {
            call.cancel();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        forecastAdapter.setListener(ForecastAdapter.OnForecastItemClickListener.DUMMY);
    }

    @Override
    public void onResponse(Call<ForecastRepository> call, Response<ForecastRepository> response) {
        if (response == null) {
            forecastAdapter.setForecastRepository(null);
        } else {
            forecastAdapter.setForecastRepository(response.body());
        }
    }

    @Override
    public void onFailure(Call<ForecastRepository> call, Throwable t) {

    }
}
