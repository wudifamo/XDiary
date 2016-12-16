package com.k.xdiary.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/12/15.
 */

public class BaseFragment extends LazyFragment {

	protected Gson gson = new Gson();
	protected Context mContext;

	@Override
	protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return null;
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void setDefaultFragmentTitle(String title) {

	}
}
