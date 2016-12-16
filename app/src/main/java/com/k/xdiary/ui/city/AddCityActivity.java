package com.k.xdiary.ui.city;

import android.os.Bundle;
import android.transition.Explode;
import android.view.View;

import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;

public class AddCityActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initParms(Bundle parms) {

	}

	@Override
	public int bindLayout() {
		getWindow().setEnterTransition(new Explode().setDuration(1000));
		getWindow().setExitTransition(new Explode().setDuration(1000));
		return R.layout.activity_add_city;
	}

	@Override
	public void initView(View view) {

	}

	@Override
	public void doBusiness() {

	}

	@Override
	public void widgetClick(View v) {

	}
}
