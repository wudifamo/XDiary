package com.k.xdiary.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.k.xdiary.R;

/**
 * Created by Administrator on 2016/12/27.
 */

public class MainParalView extends FrameLayout {

	private Context mContext;

	public MainParalView(Context context) {
		super(context);
		init(context);
	}

	public MainParalView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Paral);
		TextView textView = (TextView) findViewById(R.id.paral_tv);
		textView.setText(a.getText(R.styleable.Paral_text_content));
		float pheight = a.getDimension(R.styleable.Paral_para_height, 50);
		FrameLayout fl = (FrameLayout) findViewById(R.id.para_fl);
		ViewGroup.LayoutParams layoutParams=(ViewGroup.LayoutParams)fl.getLayoutParams();
	}

	private void init(Context context) {
		mContext = context;
		LayoutInflater.from(context).inflate(R.layout.view_main_paral, this, true);
		setRotation(-45);
	}
}
