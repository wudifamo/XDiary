package com.k.xdiary.base;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.k.xdiary.R;
import com.k.xdiary.views.MySwipeRefreshLayout.MySwipeRefreshLayout;

/**
 * Created by Administrator on 2016/12/21.
 */

public class RecyclerBaseActivity extends BaseActivity implements MySwipeRefreshLayout.OnRefreshListener, AppBarLayout.OnOffsetChangedListener {
	protected RecyclerView recyclerView;
	protected MySwipeRefreshLayout mSwipeRefreshLayout;
	protected FloatingActionButton mFab;
	protected BaseItemDraggableAdapter mAdapter;
	protected int currentPage = 0;

	@Override
	public void initParms(Bundle parms) {

	}

	@Override
	public int bindLayout() {
		return R.layout.activity_weight;
	}

	@Override
	public void initView(View view) {
		mFab = (FloatingActionButton) findViewById(R.id.weight_fb);
		mFab.setOnClickListener(this);
		AppBarLayout appbar_layout = (AppBarLayout) findViewById(R.id.weight_appbar);
		appbar_layout.addOnOffsetChangedListener(this);
		mSwipeRefreshLayout = (MySwipeRefreshLayout) findViewById(R.id.weight_swipeLayout);
		mSwipeRefreshLayout.setOnRefreshListener(this);
		mSwipeRefreshLayout.setmRecyclerView(recyclerView);
		//mSwipeRefreshLayout.setColorSchemeResources(R.color.swiperefresh_color1, R.color.swiperefresh_color2, R.color.swipe
		mAdapter.isFirstOnly(false);
		recyclerView = (RecyclerView) findViewById(R.id.weight_recyclerview);
		recyclerView.setHasFixedSize(true);
		recyclerView.post(new Runnable() {
			@Override
			public void run() {
				int rt = recyclerView.getTop();
				mSwipeRefreshLayout.setProgressViewOffset(true, rt, rt + 100);
			}
		});
		recyclerView.setAdapter(mAdapter);
		ItemDragAndSwipeCallback mItemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
		ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(mItemDragAndSwipeCallback);
		mItemTouchHelper.attachToRecyclerView(recyclerView);

		mItemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);
		ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
		itemTouchHelper.attachToRecyclerView(recyclerView);
		// 开启拖拽
//		mWeightAdapter.enableDragItem(false);
//		mWeightAdapter.setOnItemDragListener(onItemDragListener);

	}

	@Override
	public void doBusiness() {

	}

	@Override
	public void widgetClick(View v) {

	}

	@Override
	public void onRefresh() {
		refreshData();
	}

	@Override
	public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
		if (verticalOffset >= 0) {
			mSwipeRefreshLayout.setEnabled(true);
		} else {
			mSwipeRefreshLayout.setEnabled(false);
		}
	}

	public void refreshData() {
		mAdapter.setEnableLoadMore(false);
		mAdapter.setEnableLoadMore(true);
		mSwipeRefreshLayout.setRefreshing(false);
	}
}
