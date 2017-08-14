package com.example.pb.apixuweather.ui.adapter;

import android.content.Context;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastHolder> {

    public interface OnForecastItemClickListener {
        void OnForecastItemClick(ForecastDay forecastDay);

        OnForecastItemClickListener DUMMY = new OnForecastItemClickListener() {
            @Override
            public void OnForecastItemClick(ForecastDay forecastDay) {
            }
        };
    }

    private ForecastRepository forecastRepository;
    private LayoutInflater inflater;
    private Context context;
    private OnForecastItemClickListener listener = OnForecastItemClickListener.DUMMY;

    public ForecastAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setForecastRepository(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
        notifyDataSetChanged();
    }

    public void setListener(OnForecastItemClickListener listener) {
        this.listener = listener;
    }

    public ForecastDay getForecastDay(int position) {
        return forecastRepository.getForecast().getForecastDay().get(position);
    }

    @Override
    public ForecastHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ForecastHolder(inflater.inflate(R.layout.forecast_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ForecastHolder holder, int position) {
        ForecastDay forecastDay = forecastRepository.getForecast().getForecastDay().get(position);
        Glide.with(context).load("http:" + forecastDay.getDay().getCondition().getIcon()).into(holder.icon);
        holder.day.setText(forecastDay.getDate());
        holder.weather.setText(forecastDay.getDay().getCondition().getText());
        holder.tempDay.setText(String.valueOf(forecastDay.getDay().getMaxtempC()));
        holder.tempNight.setText(String.valueOf(forecastDay.getDay().getMintempC()));
    }

    @Override
    public int getItemCount() {
        return forecastRepository == null ? 0 : forecastRepository.getItemsCount();
    }

    public class ForecastHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.forecast_item_icon) ImageView icon;
        @BindView(R.id.forecast_item_day) TextView day;
        @BindView(R.id.forecast_item_weather) TextView weather;
        @BindView(R.id.forecast_item_temp_day) TextView tempDay;
        @BindView(R.id.forecast_item_temp_night) TextView tempNight;

        public ForecastHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.OnForecastItemClick(getForecastDay(getAdapterPosition()));
        }
    }
}
