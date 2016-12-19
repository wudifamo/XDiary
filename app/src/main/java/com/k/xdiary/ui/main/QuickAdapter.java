package com.k.xdiary.ui.main;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.k.xdiary.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */

public class QuickAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

	public QuickAdapter(Context context, List<String> dailyList) {
		super(R.layout.weather_item, dailyList);
	}

	@Override
	protected void convert(BaseViewHolder helper, String item) {
		helper.setText(R.id.witem_tv, item);
	}
}
