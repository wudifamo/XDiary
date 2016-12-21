package com.k.xdiary.ui.diary;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.k.xdiary.base.RecyclerBaseActivity;
import com.k.xdiary.bean.WeightBean;
import com.k.xdiary.dao.RealmHelper;
import com.k.xdiary.ui.weight.WeightAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/21.
 */

public class DiaryActivity extends RecyclerBaseActivity {
	private ArrayList<WeightBean> weightList = new ArrayList<>();
	private StaggeredGridLayoutManager layoutManager;

	@Override
	public void initParms(Bundle parms) {

	}

	@Override
	public void initView(View view) {
		mAdapter = new WeightAdapter(mContext, weightList);
		super.initView(view);
		layoutManager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setHasFixedSize(true);
		mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
		layoutManager.findFirstVisibleItemPositions(null);
		mAdapter.enableSwipeItem();
	}

	@Override
	public void doBusiness() {
		weightList.clear();
		weightList.addAll(RealmHelper.queryAllWeight());
		mAdapter.setNewData(weightList);
		mAdapter.setEnableLoadMore(false);
		mAdapter.setEnableLoadMore(true);
	}

	@Override
	public void widgetClick(View v) {

	}
}
