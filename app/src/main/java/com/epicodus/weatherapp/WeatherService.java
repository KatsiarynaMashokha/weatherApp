package com.epicodus.weatherapp;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 10/17/17.
 */

public class WeatherService {
    // Callback will execute when API request received
    public static void findForecast(String location, Callback callback) {
        // Creates and sends the request
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.OPEN_WEATHER_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.OPEN_WEATHER_LOCATION_QUERY_PARAM, location)
                .addQueryParameter(Constants.OPEN_WEATHER_UNITS_QUERY_PARAM, Constants.OPEN_WEATHER_UNITS_VALUE)
                .addQueryParameter(Constants.OPEN_WEATHER_API_ID_QUERY_PARAM, Constants.OPEN_WEATHER_API_KEY);

        String url = urlBuilder.build().toString();

        // Http request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // A call is a request that has been prepared for execution
        Call call = client.newCall(request);
        // Schedules the request to be executed at some point in the future
        call.enqueue(callback);
    }
}
