package com.k.xdiary.ui.diary;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.k.xdiary.R;
import com.k.xdiary.bean.DiaryBean;
import com.k.xdiary.utils.ViewUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/16.
 */

public class DiaryAdapter extends BaseQuickAdapter<DiaryBean, BaseViewHolder> {

	private ArrayList<DiaryBean> listDiary;

	public DiaryAdapter(Context context, ArrayList<DiaryBean> weightList) {
		super(R.layout.item_diary, weightList);
		listDiary = weightList;
	}

	@Override
	protected void convert(BaseViewHolder helper, DiaryBean item) {
		helper.setText(R.id.diary_item_title, item.getContent());
		ViewUtils.getFrescoController((SimpleDraweeView) helper.getView(R.id.diary_item_simpleDraweeView), item.getImgUrl(), 300, 200);
	}

}
