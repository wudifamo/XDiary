package com.k.xdiary.ui.main;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.k.xdiary.R;
import com.k.xdiary.bean.WeightBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/16.
 */

public class QuickAdapter extends BaseQuickAdapter<WeightBean, BaseViewHolder> {

	public QuickAdapter(Context context, ArrayList<WeightBean> weightList) {
		super(R.layout.weather_item, weightList);
	}

	@Override
	protected void convert(BaseViewHolder helper, WeightBean item) {
		helper.setText(R.id.witem_tv, item.getDate());
	}
}
