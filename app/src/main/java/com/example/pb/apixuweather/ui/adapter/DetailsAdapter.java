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
import com.example.pb.apixuweather.model.ForecastHour;
import com.example.pb.apixuweather.utils.TextFormatUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailHolder> {

    private ForecastDay forecastDay;
    private final Context context;
    private final LayoutInflater inflater;

    public DetailsAdapter(Context context, ForecastDay forecastDay) {
        this.forecastDay = forecastDay;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public DetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailHolder(inflater.inflate(R.layout.forecast_detail_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DetailHolder holder, int position) {
        ForecastHour forecastHour = forecastDay.getHour().get(position);
        holder.detailTime.setText(forecastHour.getHourTime());
        Glide.with(context).load("http:" + forecastHour.getCondition().getIcon()).into(holder.detailIcon);
        holder.detailTemp.setText(TextFormatUtils.getFormattedTemperature(context, forecastHour.getTempC()));
    }

    @Override
    public int getItemCount() {
        if (forecastDay.getHour() == null) {
            return 0;
        }
        return forecastDay.getHour().size();
    }

    public void setForecast(ForecastDay forecastDay) {
        this.forecastDay = forecastDay;
        notifyDataSetChanged();
    }

    public class DetailHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.forecast_detail_item_temp) TextView detailTemp;
        @BindView(R.id.forecast_detail_item_icon) ImageView detailIcon;
        @BindView(R.id.forecast_detail_item_time) TextView detailTime;

        public DetailHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
