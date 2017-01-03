package com.k.xdiary.ui.diary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;
import com.k.xdiary.bean.DiaryBean;
import com.k.xdiary.dao.RealmHelper;
import com.k.xdiary.utils.BaseUtils;
import com.k.xdiary.utils.CircularAnimUtil;
import com.k.xdiary.views.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

/**
 * Created by Administrator on 2016/12/21.
 */

public class DiaryActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener {
	private ArrayList<DiaryBean> diaryList = new ArrayList<>();
	private RealmResults<DiaryBean> listAll;
	private StaggeredGridLayoutManager layoutManager;
	private RecyclerView recyclerView;
	private DiaryAdapter mAdapter;
	private int currentPage;

	@Override
	public void initParms(Bundle parms) {

	}

	@Override
	public int bindLayout() {
		return R.layout.activity_diary;
	}

	@Override
	public void initView(View view) {
		findViewById(R.id.diary_fb).setOnClickListener(this);
		mAdapter = new DiaryAdapter(mContext, diaryList);
		recyclerView = (RecyclerView) findViewById(R.id.diary_recyclerview);
		recyclerView.setHasFixedSize(true);
		recyclerView.setAdapter(mAdapter);
		mAdapter.isFirstOnly(true);
		layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(layoutManager);
		mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
		mAdapter.setOnLoadMoreListener(this);
		mAdapter.setLoadMoreView(new CustomLoadMoreView());
		recyclerView.addItemDecoration(new StaItemDecorator(BaseUtils.dip2px(mContext,16)));
	}

	@Override
	public void doBusiness() {
		refreshData();
	}

	@Override
	public void widgetClick(View v) {
		switch (v.getId()) {
			case R.id.diary_fb:
				Intent intent = new Intent();
				intent.setClass(mContext, AddDiaryActivity.class);
				CircularAnimUtil.startActivityForResult(DiaryActivity.this, intent, 0, findViewById(R.id.diary_fb), R.color.colorPrimary);
				break;
		}

	}

	public void refreshData() {
		currentPage = 0;
		listAll = RealmHelper.queryAll(DiaryBean.class, "id");
		diaryList.clear();
		diaryList.addAll(RealmHelper.getLimitList(listAll, currentPage, 10));
		mAdapter.setNewData(diaryList);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 1) {
			refreshData();
			BaseUtils.showSnackBar(findViewById(R.id.activity_diary), "success");
		}
	}

	@Override
	public void onLoadMoreRequested() {
		currentPage++;
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				List<DiaryBean> weightBeanList = RealmHelper.getLimitList(listAll, currentPage, 10);
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
