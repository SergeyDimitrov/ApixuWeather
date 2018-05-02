package com.example.pb.apixuweather;

import com.example.pb.apixuweather.application.ApixuApi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    private ApixuApi service;
    private MockWebServer mockWebServer;

    @Before
    public void createService() throws IOException {
        mockWebServer = new MockWebServer();
        service = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mockWebServer.url("/"))
                .build()
                .create(ApixuApi.class);
    }

    @After
    public void stopService() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        assertNotEquals(0.3, 0.1 + 0.2);
    }

    @Test
    public void getForecast() throws IOException, InterruptedException {
        enqueueResponse("forecast.json");
        service.loadForecast(ApixuApi.API_KEY, ApixuApi.CITY_REQUEST, 7).subscribe(weatherResponse -> {
            assertThat(weatherResponse, notNullValue());
            assertThat(weatherResponse.getForecast(), notNullValue());
            assertTrue(weatherResponse.getForecast().getForecastDay().size() == 7);
        });
        RecordedRequest request = mockWebServer.takeRequest();
        assertThat(request.getPath(), is("/forecast.json?key=" + ApixuApi.API_KEY
                + "&q=" + ApixuApi.CITY_REQUEST + "&days=" + 7));
    }

    @Test
    public void getCurrent() throws IOException, InterruptedException {
        enqueueResponse("current.json");
        service.loadCurrent(ApixuApi.API_KEY, ApixuApi.CITY_REQUEST).subscribe(current -> {
            assertThat(current, notNullValue());
        });
        RecordedRequest request = mockWebServer.takeRequest();
        assertThat(request.getPath(), is("/current.json?key=" + ApixuApi.API_KEY + "&q=" + ApixuApi.CITY_REQUEST));
    }

    private void enqueueResponse(String fileName) throws IOException {
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("response/" + fileName);
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        MockResponse mockResponse = new MockResponse();
        mockWebServer.enqueue(mockResponse
                .setBody(source.readString(Charset.forName("UTF-8"))));
    }
}