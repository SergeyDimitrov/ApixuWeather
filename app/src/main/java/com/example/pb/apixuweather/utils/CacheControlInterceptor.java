package com.example.pb.apixuweather.utils;

import android.content.Context;

import com.example.pb.apixuweather.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheControlInterceptor implements Interceptor {

    private final Context appContext;

    public CacheControlInterceptor(Context context) {
        appContext = context.getApplicationContext();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        String cacheHeaderValue = NetworkUtils.isNetworkAvailable(appContext)
                ? "public, max-age=2419200"
                : "public, only-if-cached, max-stale=2419200";
        Request request = originalRequest.newBuilder().build();
        Response response = chain.proceed(request);
        return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", cacheHeaderValue)
                .build();
    }
}
