package com.k.xdiary.base;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.k.xdiary.ui.weight.WeightAdapter;

import java.util.List;

import stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

/**
 * Created by Administrator on 2016/12/22.
 */

public abstract class BaseStickyDragAdapter<T, K extends BaseViewHolder> extends BaseItemDraggableAdapter<T, K> implements
		StickyRecyclerHeadersAdapter<WeightAdapter.HeaderViewHolder> {

	public BaseStickyDragAdapter(List<T> data) {
		super(data);
	}

	public BaseStickyDragAdapter(int layoutResId, List<T> data) {
		super(layoutResId, data);
	}


}
