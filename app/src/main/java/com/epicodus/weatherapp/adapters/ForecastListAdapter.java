package com.epicodus.weatherapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.weatherapp.R;
import com.epicodus.weatherapp.models.Forecast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 10/17/17.
 */

public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder> {
    private ArrayList<Forecast> mForecasts = new ArrayList<>();
    private Context mContext;

    public ForecastListAdapter(Context mContext, ArrayList<Forecast> mForecasts) {
        this.mForecasts = mForecasts;
        this.mContext = mContext;
    }

    // required by adapter
    @Override
    public ForecastListAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_item, parent, false);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    // required by adapter
    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        holder.bindForecast(mForecasts.get(position));
    }

    // required by adapter
    @Override
    public int getItemCount() {
        return mForecasts.size();
    }

    // view holder pattern for recycler view
    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.editText3) TextView mMaxTemp;

        private Context mContext;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

        }

        public void bindForecast(Forecast forecast) {
            mMaxTemp.setText(String.valueOf(forecast.getMaxTemp()));
        }
    }

}
