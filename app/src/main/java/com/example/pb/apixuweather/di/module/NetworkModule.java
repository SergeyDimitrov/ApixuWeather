package com.example.pb.apixuweather.di.module;

import android.content.Context;

import com.example.pb.apixuweather.application.ApixuApi;
import com.example.pb.apixuweather.utils.CacheControlInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
@Module
public class NetworkModule {

    private static final int DISK_CACHE_SIZE = 50 * 1024 * 1024;
    private static final int CONNECTION_TIMEOUT_SECONDS = 10;

    @Provides
    @Singleton
    Cache provideOkHttpCache(Context context) {
        File cacheDir = new File(context.getCacheDir(), "http");
        return new Cache(cacheDir, DISK_CACHE_SIZE);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(final Context context, Cache cache) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        clientBuilder.readTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        clientBuilder.addInterceptor(new CacheControlInterceptor(context));
        clientBuilder.addNetworkInterceptor(new CacheControlInterceptor(context));
        clientBuilder.cache(cache);
        return clientBuilder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApixuApi.BASE_URL)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    ApixuApi provideApixuApi(Retrofit retrofit) {
        return retrofit.create(ApixuApi.class);
    }
}
