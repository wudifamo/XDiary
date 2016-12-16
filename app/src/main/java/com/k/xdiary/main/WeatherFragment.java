package com.k.xdiary.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.k.xdiary.R;
import com.k.xdiary.base.BaseFragment;
import com.k.xdiary.bean.WeatherBean;
import com.k.xdiary.bean.WeatherBean.HeWeather5Bean.DailyForecastBean;
import com.k.xdiary.utils.HttpUtils;
import com.k.xdiary.utils.ViewUtils;

import java.util.List;

public class WeatherFragment extends BaseFragment {

	private FrameLayout weather_fl;
	private MainActivity mainActivity;

	public WeatherFragment() {
		// Required empty public constructor
	}

	@Override
	protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mContext = getContext();
		mainActivity = (MainActivity) mContext;
		View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
		weather_fl = (FrameLayout) rootView.findViewById(R.id.weather_fl);
		return rootView;
	}

	@Override
	protected void initData() {
		HttpUtils.getAsynHttp("https://free-api.heweather.com/v5/weather", new String[]{"city", "key"}, new String[]{"大连",
				"aadd7cbeac164f948a377148135461bb"}, handler);
	}

	@Override
	protected void setDefaultFragmentTitle(String title) {

	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			String result = msg.obj.toString();
			WeatherBean weatherBean = gson.fromJson(result, WeatherBean.class);
			if (weatherBean.getHeWeather5() != null && weatherBean.getHeWeather5().size() > 0 && weatherBean.getHeWeather5().get(0).getStatus()
					.equals("ok")) {
				WeatherBean.HeWeather5Bean weather5Bean = weatherBean.getHeWeather5().get(0);
				WeatherBean.HeWeather5Bean.AqiBean.CityBean aqiBean = weather5Bean.getAqi().getCity();
				mainActivity.currentAqi = ViewUtils.colorMap.get(aqiBean.getQlty());
				mainActivity.setQualityColor();
				mainActivity.main_qualities.setText("AQI " + aqiBean.getAqi() + "\n" + "PM2.5 " + aqiBean.getPm25());
				List<DailyForecastBean> dailyList = weather5Bean.getDaily_forecast();

				Snackbar.make(weather_fl, "connection success", Snackbar.LENGTH_LONG).setAction("retry", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//tv.setText("aleady click snackbar");
					}
				}).show();
			} else {
				Snackbar.make(weather_fl, "connection error", Snackbar.LENGTH_LONG).setAction("retry", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//tv.setText("aleady click snackbar");
					}
				}).show();
			}
		}
	};

}
