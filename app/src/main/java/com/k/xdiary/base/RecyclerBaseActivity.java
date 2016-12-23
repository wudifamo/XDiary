package com.k.xdiary.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.k.xdiary.R;

import stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

/**
 * Created by Administrator on 2016/12/21.
 */

public class RecyclerBaseActivity extends BaseActivity {
	protected RecyclerView recyclerView;
	protected FloatingActionButton mFab;
	protected BaseStickyDragAdapter mAdapter;
	protected int currentPage = 0;
	protected StickyRecyclerHeadersDecoration headersDecor;

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
		mAdapter.isFirstOnly(true);
		recyclerView = (RecyclerView) findViewById(R.id.weight_recyclerview);
		recyclerView.setHasFixedSize(true);
		recyclerView.setAdapter(mAdapter);
		headersDecor = new StickyRecyclerHeadersDecoration(mAdapter);
		recyclerView.addItemDecoration(headersDecor);
		ItemDragAndSwipeCallback mItemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
		ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(mItemDragAndSwipeCallback);
		mItemTouchHelper.attachToRecyclerView(recyclerView);

		mItemDragAndSwipeCallback.setSwipeMoveFlags( ItemTouchHelper.END);
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

	public void refreshData() {
		mAdapter.setEnableLoadMore(false);
		mAdapter.setEnableLoadMore(true);
	}
}
