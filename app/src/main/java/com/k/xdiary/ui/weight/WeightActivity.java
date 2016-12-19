package com.k.xdiary.ui.weight;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;
import com.k.xdiary.ui.main.QuickAdapter;
import com.k.xdiary.utils.BaseUtils;
import com.k.xdiary.utils.CircularAnimUtil;

import java.util.ArrayList;

public class WeightActivity extends BaseActivity {
	private RecyclerView recyclerView;
	private FloatingActionButton mFab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initParms(Bundle parms) {

	}

	@Override
	public int bindLayout() {
		return R.layout.activity_weight;
	}

	@Override
	public void initView(View view) {
		recyclerView = (RecyclerView) findViewById(R.id.weight_recyclerview);
		mFab = (FloatingActionButton) findViewById(R.id.weight_fb);
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
		View headerView = View.inflate(mContext, R.layout.card_temp, null);
		headerView.setLayoutParams(new DrawerLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, BaseUtils.dip2px(mContext, 100)));
		ArrayList<String> listst = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			listst.add(i + 1 + "1");
		}
		QuickAdapter mQuickAdapter = new QuickAdapter(mContext, listst);
		mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		mQuickAdapter.addHeaderView(headerView);
		recyclerView.setAdapter(mQuickAdapter);
		mFab.setOnClickListener(this);

	}

	@Override
	public void doBusiness() {

	}

	@Override
	public void widgetClick(View v) {
		switch (v.getId()) {
			case R.id.weight_fb:
				Intent intent = new Intent();
				intent.setClass(mContext, AddWeightActivity.class);
				CircularAnimUtil.startActivity(WeightActivity.this, intent, mFab, R.color.colorPrimary);
				break;
		}
	}
}
