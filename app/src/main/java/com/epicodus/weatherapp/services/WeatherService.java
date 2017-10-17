package com.epicodus.weatherapp.services;

import com.epicodus.weatherapp.Constants;
import com.epicodus.weatherapp.models.Forecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

    public ArrayList<Forecast> processResults(Response response) {
        ArrayList<Forecast> forecasts = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject mainJsonObject = jsonArray.getJSONObject(i).getJSONObject("main");
                JSONArray weatherJsonArray = jsonArray.getJSONObject(i).getJSONArray("weather");

                double maxTemp = mainJsonObject.getDouble("temp_max");
                double minTemp = mainJsonObject.getDouble("temp_min");
                double pressure = mainJsonObject.getDouble("pressure");
                double humidity = mainJsonObject.getDouble("humidity");
                String description = weatherJsonArray.getJSONObject(0).getString("description");
                String iconIndex = weatherJsonArray.getJSONObject(0).getString("icon");

                Forecast forecast = new Forecast(minTemp, maxTemp, pressure, humidity, description, iconIndex);
                forecasts.add(forecast);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return forecasts;
    }
}
