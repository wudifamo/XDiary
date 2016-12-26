package com.k.xdiary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

	public static Date string2date(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String date2stringEn(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd", Locale.ENGLISH);
		return sdf.format(date);
	}

	public static String date2string(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static AlertDialog.Builder getDialog(Context context, String content, DialogInterface.OnClickListener onclick) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(content);
		builder.setNegativeButton("cancel", null);
		builder.setPositiveButton("ok", onclick);
		return builder;
	}

	public static void showDialog(Context context, String content, DialogInterface.OnClickListener onclick) {
		AlertDialog.Builder builder = getDialog(context, content, onclick);
		builder.show();
	}

	public static void showDialog(Context context, String title, String content, DialogInterface.OnClickListener onclick) {
		AlertDialog.Builder builder = getDialog(context, content, onclick);
		builder.setTitle(title);
		builder.show();
	}

	public static void openSysAlbm(Activity activity) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_PICK);
		intent.setType("image/*");
		activity.startActivityForResult(intent, 0);
	}

}
