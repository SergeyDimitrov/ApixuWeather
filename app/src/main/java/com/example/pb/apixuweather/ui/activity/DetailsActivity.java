package com.example.pb.apixuweather.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.pb.apixuweather.R;
import com.example.pb.apixuweather.model.ForecastDay;
import com.example.pb.apixuweather.ui.fragment.DetailsFragment;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_details);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);
        ForecastDay forecastDay = getIntent().getParcelableExtra(DetailsFragment.FORECAST_DAY_KEY);
        if (fragment == null) {
            fragment = new DetailsFragment.Builder().build(forecastDay);
            fm.beginTransaction().add(R.id.container, fragment).commit();
        }
    }
}
