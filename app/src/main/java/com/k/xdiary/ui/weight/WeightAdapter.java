package com.k.xdiary.ui.weight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.k.xdiary.R;
import com.k.xdiary.base.BaseStickyDragAdapter;
import com.k.xdiary.bean.WeightBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/16.
 */

public class WeightAdapter extends BaseStickyDragAdapter<WeightBean, BaseViewHolder> {

	private ArrayList<WeightBean> listWeight;

	public WeightAdapter(Context context, ArrayList<WeightBean> weightList) {
		super(R.layout.item_weather, weightList);
		listWeight = weightList;
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

	@Override
	public long getHeaderId(int position) {
		if (position >= listWeight.size()) {
			return -1;
		} else {
			String month = listWeight.get(position).getStringDate().substring(0, 7);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date date = new Date();
			try {
				date = sdf.parse(month);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date.getTime();
		}
	}

	@Override
	public WeightAdapter.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_stick_header, parent, false);
		return new HeaderViewHolder(view) {
		};
	}

	@Override
	public void onBindHeaderViewHolder(WeightAdapter.HeaderViewHolder holder, int position) {
		holder.tv.setText(listWeight.get(position).getStringDate().substring(0, 7));

	}

	public class HeaderViewHolder extends BaseViewHolder {

		TextView tv;

		public HeaderViewHolder(View view) {
			super(view);
			tv = (TextView) view.findViewById(R.id.header_tv);
		}
	}

}
