package com.k.xdiary.ui.diary;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/12/29.
 */

public class StaItemDecorator extends RecyclerView.ItemDecoration {
	private int space;

	public StaItemDecorator(int space) {
		this.space = space;
	}

	//自定义item之间的距离，如果是第一个的话就没有距离，
	//设置上下左右的距离
	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
		//	outRect.bottom = space;
		outRect.right = space;
//		outRect.left = space;
		outRect.top = space;
	}
}
