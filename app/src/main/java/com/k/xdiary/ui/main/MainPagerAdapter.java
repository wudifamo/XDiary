package com.k.xdiary.ui.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 * Created by Mumu
 * on 2015/11/20.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
	Context mContext;

	public MainPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		mContext = context;
	}

	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class below).
		return new WeatherFragment();
	}

	@Override
	public int getCount() {
		// Show 6 total pages.
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
			case 0:
				return "weather";
			case 1:
				return "diary";
			case 2:
				return "weight";
		}
		return null;
	}
}