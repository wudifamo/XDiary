package com.k.xdiary.ui.diary;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;
import com.k.xdiary.bean.DiaryBean;
import com.k.xdiary.dao.RealmHelper;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/21.
 */

public class DiaryActivity extends BaseActivity {
	private ArrayList<DiaryBean> diaryList = new ArrayList<>();
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
	}

	@Override
	public void doBusiness() {
		refreshData();
	}

	@Override
	public void widgetClick(View v) {
		switch (v.getId()) {
			case R.id.diary_fb:
				startActivity(AddDiaryActivity.class);
				break;
		}

	}

	public void refreshData() {
		currentPage = 0;
		diaryList.clear();
		diaryList.addAll(RealmHelper.getLimitList(RealmHelper.queryAll(DiaryBean.class), currentPage, 10));
		mAdapter.setNewData(diaryList);
	}
}
