package com.k.xdiary.ui.diary;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.k.xdiary.R;
import com.k.xdiary.utils.ViewUtils;

import java.util.List;

/**
 * Created by GIGAMOLE on 7/27/16.
 */
public class AddDiaryAlbumAdapter extends PagerAdapter {

	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private List<String> imgs;

	private boolean mIsTwoWay;

	public AddDiaryAlbumAdapter(final Context context, List<String> imgs) {
		mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
		this.imgs = imgs;
	}

	@Override
	public int getCount() {
		return imgs.size();
	}

	@Override
	public int getItemPosition(final Object object) {
		return POSITION_NONE;
	}

	@Override
	public Object instantiateItem(final ViewGroup container, final int position) {
		final View view;
		view = mLayoutInflater.inflate(R.layout.adddiary_album_item, container, false);
		final SimpleDraweeView imgIv = (SimpleDraweeView) view.findViewById(R.id.addd_img);
		ViewUtils.getFrescoController(imgIv, imgs.get(position), 500, 300);
		container.addView(view);
		return view;
	}

	@Override
	public boolean isViewFromObject(final View view, final Object object) {
		return view.equals(object);
	}

	@Override
	public void destroyItem(final ViewGroup container, final int position, final Object object) {
		container.removeView((View) object);
	}
}
