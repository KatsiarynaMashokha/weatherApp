package com.epicodus.weatherapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.weatherapp.adapters.ForecastListAdapter;
import com.epicodus.weatherapp.models.Forecast;
import com.epicodus.weatherapp.R;
import com.epicodus.weatherapp.services.WeatherService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = WeatherActivity.class.getSimpleName();
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private ForecastListAdapter mAdapter;
    public ArrayList<Forecast> forecasts = new ArrayList<>();
    public static final String ZIP_KEY = "zip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        String location = getIntent().getStringExtra(ZIP_KEY);
        getForecast(location);
    }

    private void getForecast(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findForecast(location, new Callback() {
            // Executed if Api request fails
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        forecasts = weatherService.processResults(response);

                        WeatherActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                               mAdapter = new ForecastListAdapter(getApplicationContext(), forecasts);
                                mRecyclerView.setAdapter(mAdapter);
                                RecyclerView.LayoutManager layoutManager =
                                        new LinearLayoutManager(WeatherActivity.this);
                                mRecyclerView.setLayoutManager(layoutManager);
                                mRecyclerView.setHasFixedSize(true);
                            }
                        });
                    }
                }
        });
    }
}
