package com.k.xdiary.ui.diary;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.k.xdiary.R;
import com.k.xdiary.bean.DiaryBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/16.
 */

public class DiaryAdapter extends BaseQuickAdapter<DiaryBean, BaseViewHolder> {

	private ArrayList<DiaryBean> listDiary;

	public DiaryAdapter(Context context, ArrayList<DiaryBean> weightList) {
		super(R.layout.item_weather, weightList);
		listDiary = weightList;
	}

	@Override
	protected void convert(BaseViewHolder helper, DiaryBean item) {
	}

}
