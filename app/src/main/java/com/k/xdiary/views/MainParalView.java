package com.k.xdiary.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.k.xdiary.R;

/**
 * Created by Administrator on 2016/12/27.
 */

public class MainParalView extends FrameLayout {

	private Context mContext;
	private ViewDragHelper mDragger;


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
	}

	private void init(Context context) {
		mDragger = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
			@Override
			public boolean tryCaptureView(View child, int pointerId) {
				return true;
			}

			@Override
			public int clampViewPositionHorizontal(View child, int left, int dx) {
				return left;
			}

			@Override
			public int clampViewPositionVertical(View child, int top, int dy) {
				return top;
			}
		});
		mContext = context;
		LayoutInflater.from(context).inflate(R.layout.view_main_paral, this, true);
		setRotation(-45);
	}

//	@Override
//	public boolean onInterceptTouchEvent(MotionEvent event) {
//		return mDragger.shouldInterceptTouchEvent(event);
//	}
//
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		mDragger.processTouchEvent(event);
//		return true;
//	}
}
