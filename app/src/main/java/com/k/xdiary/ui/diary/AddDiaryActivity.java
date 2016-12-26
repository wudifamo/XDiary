package com.k.xdiary.ui.diary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;

import java.util.ArrayList;

import io.github.lijunguan.imgselector.ImageSelector;

public class AddDiaryActivity extends BaseActivity {

	@Override
	public void initParms(Bundle parms) {
	}

	@Override
	public int bindLayout() {
		return R.layout.activity_add_diary;
	}

	@Override
	public void initView(View view) {
		findViewById(R.id.diary_fb).setOnClickListener(this);
	}

	@Override
	public void doBusiness() {

	}

	@Override
	public void widgetClick(View v) {
		switch (v.getId()) {
			case R.id.diary_fb:
				ImageSelector.getInstance()
						.setSelectModel(ImageSelector.MULTI_MODE)
						.setMaxCount(6)
						.setGridColumns(3)
						.setShowCamera(true)
						.setToolbarColor(ContextCompat.getColor(mContext, R.color.colorPrimary))
						.startSelect(this);
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == ImageSelector.REQUEST_SELECT_IMAGE
				&& resultCode == RESULT_OK) {
			ArrayList<String> imagesPath = data.getStringArrayListExtra(ImageSelector.SELECTED_RESULT);
			if (imagesPath != null) {
				//TODO  do something...
			}
		}
	}
}
