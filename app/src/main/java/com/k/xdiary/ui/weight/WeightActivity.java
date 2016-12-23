package com.k.xdiary.ui.weight;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.k.xdiary.R;
import com.k.xdiary.base.RecyclerBaseActivity;
import com.k.xdiary.bean.WeightBean;
import com.k.xdiary.dao.RealmHelper;
import com.k.xdiary.utils.BaseUtils;
import com.k.xdiary.utils.CircularAnimUtil;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

public class WeightActivity extends RecyclerBaseActivity implements BaseQuickAdapter.RequestLoadMoreListener {
	private ArrayList<WeightBean> weightList = new ArrayList<>();
	private RealmResults<WeightBean> listAll;
	private LinearLayoutManager layoutManager;

	@Override
	public void initParms(Bundle parms) {

	}

	@Override
	public void initView(View view) {
		mAdapter = new WeightAdapter(mContext, weightList);
		super.initView(view);
		layoutManager = new LinearLayoutManager(mContext);
		//设置布局管理器
		recyclerView.setLayoutManager(layoutManager);
		//设置为垂直布局，这也是默认的
		layoutManager.setOrientation(OrientationHelper.VERTICAL);
		//设置分隔线
//		recyclerView.addItemDecoration(new RecyclerViewDivider(LinearLayoutCompat.VERTICAL, 0, ContextCompat.getColor(mContext, R.color
//				.dividerColor), 1));
		//设置增加或删除条目的动画
		//recyclerView.setItemAnimator(new DefaultItemAnimator());

		mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
			@Override
			public void onChanged() {
				headersDecor.invalidateHeaders();
			}
		});
		// 开启滑动删除
		mAdapter.enableSwipeItem();
		mAdapter.setOnItemSwipeListener(onItemSwipeListener);
		mAdapter.setOnLoadMoreListener(this);
		recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
				super.onScrollStateChanged(recyclerView, newState);
			}

			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx, dy);
				int aa = layoutManager.findFirstVisibleItemPosition();
				ImageView tv = (ImageView) recyclerView.getChildAt(aa).findViewById(R.id.witem_weather);
				int[] location = new int[2];
				// 获取scrollToView在窗体的坐标
				tv.getLocationInWindow(location);
				Log.i("---", aa + "-" + location[1] + "-" + dy);
			}
		});
	}

	@Override
	public void doBusiness() {
		refreshData();
	}

	@Override
	public void widgetClick(View v) {
		switch (v.getId()) {
			case R.id.weight_fb:
				Intent intent = new Intent();
				intent.setClass(mContext, AddWeightActivity.class);
				CircularAnimUtil.startActivityForResult(WeightActivity.this, intent, 0, mFab, R.color.colorPrimary);
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 1) {
			refreshData();
			BaseUtils.showSnackBar(findViewById(R.id.activity_weight), "success");
		}
	}

	@Override
	public void refreshData() {
		currentPage = 0;
		listAll = RealmHelper.queryAll(WeightBean.class);
		weightList.clear();
		weightList.addAll(RealmHelper.getLimitList(listAll, currentPage, 10));
		mAdapter.setNewData(weightList);
		super.refreshData();
	}

	OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
		@Override
		public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
		}

		@Override
		public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
		}

		@Override
		public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
			if (pos > 0) {
				double ss = weightList.get(pos - 1).getSum();
				weightList.get(pos - 1).setSum(RealmHelper.deleteWeight(weightList.get(pos).getDate()));
				double s1s = weightList.get(pos - 1).getSum();
				Log.i("---", pos + "");
			} else {
				RealmHelper.deleteWeight(weightList.get(pos).getDate());
			}
			if (weightList.size() < 2) {
				mAdapter.setEnableLoadMore(false);
			}
			mAdapter.setEnableLoadMore(false);
		}

		@Override
		public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float v, float v1, boolean b) {
		}
	};

	@Override
	public void onLoadMoreRequested() {
		currentPage++;
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				List<WeightBean> weightBeanList = RealmHelper.getLimitList(listAll, currentPage, 10);
				if (weightBeanList.size() <= 0) {
					mAdapter.loadMoreEnd();
				} else {
					mAdapter.addData(weightBeanList);
					mAdapter.loadMoreComplete();
				}
			}
		}, 500);

	}

}
