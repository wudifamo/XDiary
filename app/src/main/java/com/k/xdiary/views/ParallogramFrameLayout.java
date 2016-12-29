package com.k.xdiary.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.k.xdiary.R;
import com.k.xdiary.utils.BaseUtils;

/**
 * Created by Administrator on 2016/12/27.
 */

public class ParallogramFrameLayout extends FrameLayout {

	Paint mInnerPaint;
	private int mWidth, mHeight, pHeight;
	private Context mContext;

	public ParallogramFrameLayout(Context context) {
		super(context);
		init(context);
	}

	public ParallogramFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		mInnerPaint = new Paint();
		mInnerPaint.setAntiAlias(true);
		mInnerPaint.setColor(ContextCompat.getColor(mContext, R.color.primary_light));
		mInnerPaint.setStyle(Paint.Style.FILL);
		mInnerPaint.setStrokeJoin(Paint.Join.ROUND);
		setWillNotDraw(false);
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		mWidth = getWidth();
		mHeight = getHeight();
		pHeight = BaseUtils.dip2px(mContext, 100);
		Path path = new Path();
		path.moveTo(mWidth, 0);
		path.lineTo(mWidth, pHeight);
		path.lineTo(0, getHeight());
		path.lineTo(0, getHeight() - pHeight);
		path.lineTo(mWidth, 0);
		canvas.drawPath(path, mInnerPaint);
	}

}
