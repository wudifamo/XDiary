package com.k.xdiary.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Administrator on 2016/12/15.
 */

public class BaseUtils {

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	public static void showSnackBar(View view, String content, Object... objects) {
		Snackbar snackbar = Snackbar.make(view, content, Snackbar.LENGTH_LONG);
		if (objects != null && objects.length > 1) {
			snackbar.setAction(objects[0].toString(), (View.OnClickListener) objects[1]);
		}
		snackbar.show();
	}
}
