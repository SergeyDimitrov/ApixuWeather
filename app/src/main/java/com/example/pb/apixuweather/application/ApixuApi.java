package com.example.pb.apixuweather.application;

import com.example.pb.apixuweather.model.Current;
import com.example.pb.apixuweather.model.ForecastRepository;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApixuApi {

    String BASE_URL = "http://api.apixu.com/v1/";
    String API_KEY = "afd6946682834150a85202436171008";

    int DAYS_NUMBER_REQUEST = 10;
    String CITY_REQUEST = "Samara";

    @GET("forecast.json")
    Observable<ForecastRepository> loadForecast(@Query("key") String key, @Query("q") String city, @Query("days") int days);
    @GET("current.json")
    Observable<Current> loadCurrent(@Query("key") String key, @Query("q") String city);
}
