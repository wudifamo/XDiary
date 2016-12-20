package com.k.xdiary.ui.weight;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;
import com.k.xdiary.bean.WeightBean;
import com.k.xdiary.dao.RealmHelper;
import com.k.xdiary.utils.BaseUtils;
import com.k.xdiary.utils.CircularAnimUtil;

import java.util.ArrayList;

public class WeightActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, AppBarLayout.OnOffsetChangedListener,
		BaseQuickAdapter.RequestLoadMoreListener {
	private RecyclerView recyclerView;
	private FloatingActionButton mFab;
	private ArrayList<WeightBean> weightList = new ArrayList<>();
	private WeightAdapter mWeightAdapter;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private LinearLayoutManager layoutManager;

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
		layoutManager = new LinearLayoutManager(mContext);
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
		mWeightAdapter = new WeightAdapter(mContext, weightList);
		mWeightAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		mWeightAdapter.addHeaderView(headerView);

		ItemDragAndSwipeCallback mItemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mWeightAdapter);
		ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(mItemDragAndSwipeCallback);
		mItemTouchHelper.attachToRecyclerView(recyclerView);

		mItemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);
		ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mWeightAdapter);
		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
		itemTouchHelper.attachToRecyclerView(recyclerView);
		// 开启拖拽
//		mWeightAdapter.enableDragItem(false);
//		mWeightAdapter.setOnItemDragListener(onItemDragListener);

		// 开启滑动删除
		mWeightAdapter.enableSwipeItem();
		mWeightAdapter.setOnItemSwipeListener(onItemSwipeListener);
		mWeightAdapter.setOnLoadMoreListener(this);
		recyclerView.setAdapter(mWeightAdapter);
		recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx, dy);
				if (layoutManager.findViewByPosition(layoutManager.findFirstVisibleItemPosition()).getTop() == 0 && layoutManager
						.findFirstVisibleItemPosition() == 0) {
					mSwipeRefreshLayout.setEnabled(true);
				} else {
					mSwipeRefreshLayout.setEnabled(false);
				}
			}
		});
		mFab.setOnClickListener(this);

		mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.weight_swipeLayout);
		mSwipeRefreshLayout.setOnRefreshListener(this);
		mSwipeRefreshLayout.setProgressViewOffset(true, 100, 200);
		//mSwipeRefreshLayout.setColorSchemeResources(R.color.swiperefresh_color1, R.color.swiperefresh_color2, R.color.swipe
		AppBarLayout appbar_layout = (AppBarLayout) findViewById(R.id.weight_appbar);
		appbar_layout.addOnOffsetChangedListener(this);
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

	private void refreshData() {
		weightList.clear();
		weightList.addAll(new RealmHelper().queryAllWeight());
		mWeightAdapter.notifyDataSetChanged();
		mSwipeRefreshLayout.setRefreshing(false);
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
			Log.i("---", pos + "");
		}

		@Override
		public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float v, float v1, boolean b) {

		}
	};

	@Override
	public void onRefresh() {
		refreshData();
	}

	@Override
	public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//		if (layoutManager != null && layoutManager.findViewByPosition(layoutManager.findFirstVisibleItemPosition()) != null && verticalOffset >= 0
//				&& layoutManager.findViewByPosition(layoutManager.findFirstVisibleItemPosition()).getTop()
//				== 0 && layoutManager
//				.findFirstVisibleItemPosition() == 0) {
//			mSwipeRefreshLayout.setEnabled(true);
//		} else {
//			mSwipeRefreshLayout.setEnabled(false);
//		}
	}

	@Override
	public void onLoadMoreRequested() {

	}
}
