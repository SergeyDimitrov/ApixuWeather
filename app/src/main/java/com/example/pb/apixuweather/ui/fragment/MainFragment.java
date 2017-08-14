package com.example.pb.apixuweather.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.pb.apixuweather.application.ApixuWeatherApplication;
import com.example.pb.apixuweather.R;
import com.example.pb.apixuweather.model.ForecastDay;
import com.example.pb.apixuweather.model.ForecastRepository;
import com.example.pb.apixuweather.application.ApixuApi;
import com.example.pb.apixuweather.mvp.presenter.ForecastLoaderPresenter;
import com.example.pb.apixuweather.mvp.view.ForecastLoaderView;
import com.example.pb.apixuweather.ui.activity.DetailsActivity;
import com.example.pb.apixuweather.ui.adapter.ForecastAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends BaseFragment implements ForecastLoaderView {

    @InjectPresenter
    ForecastLoaderPresenter forecastLoaderPresenter;

    @BindView(R.id.main_forecast_list)
    RecyclerView forecastList;
    @BindView(R.id.list_load_progress)
    ProgressBar progressBar;

    private ForecastAdapter forecastAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        forecastLoaderPresenter.startLoading();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        forecastAdapter.setListener(ForecastAdapter.OnForecastItemClickListener.DUMMY);
    }

    @Override
    public void setForecastRepository(ForecastRepository forecastRepository) {
        forecastAdapter.setForecastRepository(forecastRepository);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        forecastList.setVisibility(View.INVISIBLE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        forecastList.setVisibility(View.VISIBLE);
    }
}
