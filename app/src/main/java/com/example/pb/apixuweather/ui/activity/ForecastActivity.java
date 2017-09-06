package com.example.pb.apixuweather.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.example.pb.apixuweather.R;
import com.example.pb.apixuweather.ui.fragment.ForecastFragment;

public class ForecastActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);
        if (fragment == null) {
            fragment = new ForecastFragment();
            fm.beginTransaction().add(R.id.container, fragment).commit();
        }
    }
}
