package com.example.pb.apixuweather.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pb.apixuweather.R;
import com.example.pb.apixuweather.data.ForecastDay;

public class DetailsFragment extends BaseFragment {

    public static final String FORECAST_DAY_KEY = "FORECAST_DAY_KEY";
    private ForecastDay forecast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forecast = getArguments().getParcelable(FORECAST_DAY_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_details, container, false);
    }

    public static class Builder {
        public DetailsFragment build(ForecastDay forecastDay) {
            DetailsFragment fragment = new DetailsFragment();
            Bundle args = new Bundle();
            args.putParcelable(FORECAST_DAY_KEY, forecastDay);
            fragment.setArguments(args);
            return fragment;
        }
    }
}
