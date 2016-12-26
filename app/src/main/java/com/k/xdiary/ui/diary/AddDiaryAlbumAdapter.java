package com.k.xdiary.ui.diary;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.k.xdiary.R;

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
		ImageRequest request = ImageRequestBuilder
				.newBuilderWithSource(Uri.parse("file://" + imgs.get(position)))
				.setResizeOptions(new ResizeOptions(500, 300))
				.build();
		AbstractDraweeController controller = Fresco.newDraweeControllerBuilder().setOldController(imgIv.getController()).setImageRequest
				(request)
				.build();
		imgIv.setController(controller);
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
