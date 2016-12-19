package com.k.xdiary.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.k.xdiary.R;
import com.k.xdiary.base.BaseFragment;

public class WeatherFragment extends BaseFragment {

	private MainActivity mainActivity;
	private RecyclerView recyclerView;

	public WeatherFragment() {
		// Required empty public constructor
	}

	@Override
	protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mContext = getContext();
		mainActivity = (MainActivity) mContext;
		View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
		recyclerView = (RecyclerView) rootView.findViewById(R.id.weather_recyclerview);
		LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
		//设置布局管理器
		recyclerView.setLayoutManager(layoutManager);
		//设置为垂直布局，这也是默认的
		layoutManager.setOrientation(OrientationHelper.VERTICAL);
		recyclerView.setHasFixedSize(true);
		//设置分隔线
		//recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
		//设置增加或删除条目的动画
		//recyclerView.setItemAnimator(new DefaultItemAnimator());
		return rootView;
	}

	@Override
	protected void initData() {
	}

	@Override
	protected void setDefaultFragmentTitle(String title) {

	}



}
