package com.k.xdiary.ui.weight;

import android.content.Context;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.k.xdiary.R;
import com.k.xdiary.bean.WeightBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/16.
 */

public class WeightAdapter extends BaseItemDraggableAdapter<WeightBean, BaseViewHolder> {

	public WeightAdapter(Context context, ArrayList<WeightBean> weightList) {
		super(R.layout.weather_item, weightList);
	}

	@Override
	protected void convert(BaseViewHolder helper, WeightBean item) {
		helper.setText(R.id.witem_tv0, item.getStringDate())
				.setText(R.id.witem_tv, item.getWeight())
				.setText(R.id.witem_tv2, item.getSum() + "");
		if (item.getSum() > 0) {
			helper.setText(R.id.witem_tv1, "↑");
		} else {
			helper.setText(R.id.witem_tv1, "↓");
		}
	}
}
