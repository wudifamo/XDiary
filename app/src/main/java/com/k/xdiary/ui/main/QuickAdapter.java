package com.k.xdiary.ui.main;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.k.xdiary.R;
import com.k.xdiary.bean.WeatherBean.HeWeather5Bean.DailyForecastBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */

public class QuickAdapter extends BaseQuickAdapter<DailyForecastBean, BaseViewHolder> {

	public QuickAdapter(Context context, List<DailyForecastBean> dailyList) {
		super(R.layout.weather_item, dailyList);
	}

	@Override
	protected void convert(BaseViewHolder helper, DailyForecastBean item) {
		helper.setText(R.id.witem_tv, item.getTmp().getMax())
				.setText(R.id.witem_tv0, item.getDate());
	}
}
