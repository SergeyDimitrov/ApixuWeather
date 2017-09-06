package com.example.pb.apixuweather.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.pb.apixuweather.R;
import com.example.pb.apixuweather.model.ForecastRepository;
import com.example.pb.apixuweather.mvp.presenter.ForecastLoaderPresenter;
import com.example.pb.apixuweather.mvp.view.ForecastLoaderView;
import com.example.pb.apixuweather.ui.adapter.ForecastAdapter;
import com.example.pb.apixuweather.utils.AnimationUtils;
import com.example.pb.apixuweather.utils.ScreenUtils;

import butterknife.BindView;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class ForecastFragment extends BaseFragment implements ForecastLoaderView {

    @InjectPresenter
    ForecastLoaderPresenter forecastLoaderPresenter;

    @BindView(R.id.main_forecast_list) RecyclerView forecastList;
    @BindView(R.id.list_load_progress) ProgressBar progressBar;

    private ForecastAdapter forecastAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forecastAdapter = new ForecastAdapter(getContext());
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
        forecastList.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
    }

    @Override
    public void onStart() {
        super.onStart();
        forecastLoaderPresenter.startLoading();
    }

    @Override
    public void setForecastRepository(ForecastRepository forecastRepository) {
        forecastAdapter.setForecastRepository(forecastRepository);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        forecastList.setTranslationY(ScreenUtils.getScreenHeight(getContext()));
    }

    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        AnimationUtils.slideUpAnimation(forecastList);
    }
}
