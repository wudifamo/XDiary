package com.k.xdiary.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;

public class MainActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener {

	private MainPagerAdapter mainPagerAdapter;
	private ViewPager mViewPager;
	public TextView main_appbar_tv, main_qualities;
	private int totalScrollRange = -1;
	public String currentAqi = "ffffff";
	private float currentExpd = 0;
	public FloatingActionButton mFab;

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
		mFab = (FloatingActionButton) findViewById(R.id.main_fb);
		mFab.setOnClickListener(new FabClick());
		Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);
		main_appbar_tv = (TextView) findViewById(R.id.main_appbar_tv);
		main_qualities = (TextView) findViewById(R.id.main_qualities);
		NavigationView mNavView = (NavigationView) findViewById(R.id.nav_view);
		DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
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
		CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_collapsingbar);
		mCollapsingToolbarLayout.setTitle("6℃");
		//扩张颜色
		mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
		//收缩后在Toolbar上显示时的title的颜色
		mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#90000000"));
		mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mContext);
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mViewPager.setAdapter(mainPagerAdapter);
		mViewPager.setOffscreenPageLimit(3);
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
		tabLayout.setupWithViewPager(mViewPager);
	}

	@Override
	public void doBusiness() {

	}

	@Override
	public void widgetClick(View v) {

	}

	@Override
	public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
		if (totalScrollRange > 0) {
			currentExpd = 1 - Math.abs((float) verticalOffset / (float) totalScrollRange);
			main_appbar_tv.setTextSize(currentExpd * 36 + 14);
			setQualityColor();
		}
	}

	public void setQualityColor() {
		try {
			String xi = String.valueOf((int) (99 * currentExpd)).length() < 2 ? "00" : String.valueOf((int) (99 * currentExpd));
			main_qualities.setTextColor(Color.parseColor("#" + xi + currentAqi));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class FabClick implements View.OnClickListener {

		@Override
		public void onClick(View view) {
			switch (mViewPager.getCurrentItem()) {
				case 0:
//					Intent intent = new Intent();
//					intent.setClass(mContext, AddCityActivity.class);
//					Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
//					startActivity(intent, bundle);
					break;
			}
		}
	}
}
