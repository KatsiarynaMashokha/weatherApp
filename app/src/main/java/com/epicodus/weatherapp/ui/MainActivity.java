package com.epicodus.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.weatherapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String ZIP_KEY = "zip";
    @Bind(R.id.zipCodeEditText) EditText mZipCodeEditText;
    @Bind(R.id.searchButton) Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mSearchButton) {
            String zipCode = mZipCodeEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
            intent.putExtra(ZIP_KEY, zipCode);
            startActivity(intent);
        }
    }
}
