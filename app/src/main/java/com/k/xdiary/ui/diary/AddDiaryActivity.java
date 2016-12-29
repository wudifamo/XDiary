package com.k.xdiary.ui.diary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.florent37.viewanimator.ViewAnimator;
import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;
import com.k.xdiary.bean.DiaryBean;
import com.k.xdiary.dao.RealmHelper;
import com.k.xdiary.utils.BaseUtils;
import com.k.xdiary.utils.ViewUtils;

import java.util.ArrayList;

import io.github.lijunguan.imgselector.ImageSelector;


public class AddDiaryActivity extends BaseActivity {
	//	private HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager;
	private FrameLayout adddiary_imgs_fl;
	private EditText adddiary_content;
	private ArrayList<String> imagesPath;

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
		adddiary_imgs_fl = (FrameLayout) findViewById(R.id.adddiary_imgs_fl);
		adddiary_content = (EditText) findViewById(R.id.adddiary_content);
//		horizontalInfiniteCycleViewPager = (HorizontalInfiniteCycleViewPager) view.findViewById(R.id.diary_hicvp);
		toolbar_btnRight.setText("done");
		toolbar_btnRight.setVisibility(View.VISIBLE);
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
						.setShowCamera(false)
						.setToolbarColor(ContextCompat.getColor(mContext, R.color.colorPrimary))
						.startSelect(this);
				break;
			case R.id.toolbar_btnRight:
				if (imagesPath == null) {
					DiaryBean diaryBean = new DiaryBean();
					diaryBean.setId(System.currentTimeMillis());
					diaryBean.setContent(adddiary_content.getText().toString());
					diaryBean.setWeather(BaseUtils.getTodayWeather(mContext));
					diaryBean.setTmp(BaseUtils.getTodayTmp(mContext));
					RealmHelper.addRealm(diaryBean);
				} else {
					for (String imgStr : imagesPath) {
						DiaryBean diaryBean = new DiaryBean();
						diaryBean.setId(System.currentTimeMillis());
						diaryBean.setContent(adddiary_content.getText().toString());
						diaryBean.setWeather(BaseUtils.getTodayWeather(mContext));
						diaryBean.setTmp(BaseUtils.getTodayTmp(mContext));
						diaryBean.setImgUrl(imgStr);
						RealmHelper.addRealm(diaryBean);
					}
				}
				setResult(1);
				finish();
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == ImageSelector.REQUEST_SELECT_IMAGE
				&& resultCode == RESULT_OK) {
			imagesPath = data.getStringArrayListExtra(ImageSelector.SELECTED_RESULT);
			if (imagesPath != null) {
				//TODO  do something...
//				horizontalInfiniteCycleViewPager.setAdapter(new AddDiaryAlbumAdapter(mContext, imagesPath));
				adddiary_imgs_fl.removeAllViews();
				for (int i = 0; i < imagesPath.size(); i++) {
					SimpleDraweeView sdv = (SimpleDraweeView) View.inflate(mContext, R.layout.view_fresco_card, null);
					FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
					sdv.setElevation(i * 3);
					lp.topMargin = 100 * i + 1000;
					ViewUtils.getFrescoController(sdv, imagesPath.get(i), 500, 300);
					adddiary_imgs_fl.addView(sdv, lp);

					ViewAnimator.animate(sdv)
							.translationY(-1000)
							.interpolator(new DecelerateInterpolator())
							.duration(500)
							.startDelay(200 * i)
							.start();
					sdv.setOnTouchListener(new View.OnTouchListener() {
						@Override
						public boolean onTouch(View view, MotionEvent motionEvent) {
							switch (motionEvent.getAction()) {
								case MotionEvent.ACTION_DOWN:
									view.setTranslationZ(100);
									break;
								case MotionEvent.ACTION_UP:
								case MotionEvent.ACTION_CANCEL:
									view.setTranslationZ(0);
									break;
							}
							return true;
						}
					});
				}
			}
		}
	}
}
