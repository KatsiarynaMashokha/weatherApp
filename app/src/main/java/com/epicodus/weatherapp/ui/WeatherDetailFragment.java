package com.epicodus.weatherapp.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.weatherapp.R;
import com.epicodus.weatherapp.models.Forecast;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherDetailFragment extends Fragment {
    @Bind(R.id.highTempTextViewValue) TextView mMaxTemp;

    private Forecast mForecast;

    public static WeatherDetailFragment newInstance(Forecast forecast) {
        WeatherDetailFragment weatherDetailFragment = new WeatherDetailFragment();
        Bundle b = new Bundle();
        b.putParcelable("weather", Parcels.wrap(forecast));
        weatherDetailFragment.setArguments(b);
        return weatherDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mForecast = Parcels.unwrap(getArguments().getParcelable("weather"));
    }

    public WeatherDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_weather_detail, container, false);
        ButterKnife.bind(this, view);

        mMaxTemp.setText(String.valueOf(mForecast.getMaxTemp()));
        return view;

    }

}
