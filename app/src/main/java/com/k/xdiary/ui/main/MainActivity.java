package com.k.xdiary.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;
import com.k.xdiary.ui.diary.DiaryActivity;

public class MainActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener {

	private TextView main_appbar_tv;
	private int totalScrollRange = -1;
	private float currentExpd = 0;
	private DrawerLayout mDrawerLayout;
	private CollapsingToolbarLayout mCollapsingToolbarLayout;
	private CardView cardView1, cardView2, cardView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initParms(Bundle parms) {

	}

	@Override
	public int bindLayout() {
		return R.layout.activity_main;
	}

	@Override
	public void initView(View view) {
		mSwipeBackLayout.setEnableGesture(false);
		cardView1 = (CardView) findViewById(R.id.main_card1);
		cardView2 = (CardView) findViewById(R.id.main_card2);
		cardView3 = (CardView) findViewById(R.id.main_card3);
		Toolbar mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
		setSupportActionBar(mToolbar);
		main_appbar_tv = (TextView) findViewById(R.id.main_appbar_tv);
		NavigationView mNavView = (NavigationView) findViewById(R.id.nav_view);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		//mNavView.setNavigationItemSelectedListener(this);
		//navigationView.setItemIconTintList(null);
		mNavView.inflateHeaderView(R.layout.nav_header_main);
		final AppBarLayout appbar_layout = (AppBarLayout) findViewById(R.id.appbar_layout);
		appbar_layout.addOnOffsetChangedListener(this);
		appbar_layout.post(new Runnable() {
			@Override
			public void run() {
				totalScrollRange = appbar_layout.getTotalScrollRange();
			}
		});
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string
				.navigation_drawer_close);
		mDrawerLayout.addDrawerListener(toggle);
		toggle.syncState();
		mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_collapsingbar);
		//扩张颜色
		mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
		//收缩后在Toolbar上显示时的title的颜色
		mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#90000000"));

		cardView1.setOnClickListener(this);
		cardView2.setOnClickListener(this);
		cardView3.setOnClickListener(this);
	}

	@Override
	public void doBusiness() {
	}

	@Override
	public void widgetClick(View v) {
		switch (v.getId()) {
			case R.id.main_card1:
//				Intent intent = new Intent();
//				intent.setClass(MainActivity.this, WeightActivity.class);
//				Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
//				startActivity(intent, bundle);
//				startActivity(new Intent(mContext, WeightActivity.class), ActivityOptions.makeSceneTransitionAnimation(this, cardView1, "weight")
//						.toBundle());
				break;
			case R.id.main_card2:
				startActivity(DiaryActivity.class);
				break;
			case R.id.main_card3:
				break;
		}
	}

	@Override
	public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
		if (totalScrollRange > 0) {
			currentExpd = 1 - Math.abs((float) verticalOffset / (float) totalScrollRange);
			main_appbar_tv.setTextSize(currentExpd * 36 + 14);
		}
	}

}
