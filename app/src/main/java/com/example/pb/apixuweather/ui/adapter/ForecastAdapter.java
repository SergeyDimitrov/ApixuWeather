package com.example.pb.apixuweather.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pb.apixuweather.R;
import com.example.pb.apixuweather.model.ForecastDay;
import com.example.pb.apixuweather.model.ForecastRepository;
import com.example.pb.apixuweather.utils.TextFormatUtils;

import java.util.Objects;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastHolder> {

    private ForecastRepository forecastRepository;
    private LayoutInflater inflater;
    private Context context;

    public ForecastAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setForecastRepository(ForecastRepository forecastRepository) {
        if (Objects.equals(this.forecastRepository, forecastRepository)) {
            return;
        }
        this.forecastRepository = forecastRepository;
        notifyDataSetChanged();
    }

    @Override
    public ForecastHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ForecastHolder(inflater.inflate(R.layout.forecast_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ForecastHolder holder, int position) {
        ForecastDay forecastDay = forecastRepository.getForecast().getForecastDay().get(position);
        UUID oldForecastId = holder.getForecastId();
        if (Objects.equals(forecastDay.getId(), oldForecastId)) {
            return;
        }
        Glide.with(context).load("http:" + forecastDay.getDay().getCondition().getIcon()).into(holder.icon);
        holder.day.setText(forecastDay.getDate());
        holder.weather.setText(forecastDay.getDay().getCondition().getText());
        holder.tempDay.setText(TextFormatUtils.getFormattedTemperature(context, forecastDay.getDay().getMaxtempC()));
        holder.tempNight.setText(TextFormatUtils.getFormattedTemperature(context, forecastDay.getDay().getMintempC()));
        if (oldForecastId == null) {
            holder.detailsList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.detailsList.setAdapter(new DetailsAdapter(context, forecastDay));
        } else {
            DetailsAdapter adapter = (DetailsAdapter) holder.detailsList.getAdapter();
            adapter.setForecast(forecastDay);
        }
        holder.setForecastId(forecastDay.getId());
    }

    @Override
    public int getItemCount() {
        return forecastRepository == null ? 0 : forecastRepository.getItemsCount();
    }

    public class ForecastHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.forecast_item_icon) ImageView icon;
        @BindView(R.id.forecast_item_day) TextView day;
        @BindView(R.id.forecast_item_weather) TextView weather;
        @BindView(R.id.forecast_item_temp_day) TextView tempDay;
        @BindView(R.id.forecast_item_temp_night) TextView tempNight;
        @BindView(R.id.forecast_details_list) RecyclerView detailsList;

        private UUID forecastId;

        public ForecastHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public UUID getForecastId() {
            return forecastId;
        }

        public void setForecastId(UUID forecastId) {
            this.forecastId = forecastId;
        }
    }
}
