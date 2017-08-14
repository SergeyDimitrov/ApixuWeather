package com.example.pb.apixuweather.application;

import com.example.pb.apixuweather.model.ForecastRepository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApixuApi {

    String BASE_URL = "http://api.apixu.com/v1/";
    String API_KEY = "afd6946682834150a85202436171008";

    int DAYS_NUMBER_REQUEST = 10;
    String CITY_REQUEST = "Samara";

    @GET("forecast.json")
    Call<ForecastRepository> loadForecast(@Query("key") String key, @Query("q") String city, @Query("days") int days);
}
