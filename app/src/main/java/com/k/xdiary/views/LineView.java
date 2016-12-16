package com.k.xdiary.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/12/15.
 */

public class LineView extends View {

	private Paint mPaint;

	public LineView(Context context) {
		super(context);
	}

	public LineView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint mPaint = new Paint();
		Path mPath = new Path();
		mPaint.setColor(Color.WHITE); //画笔颜色
		mPaint.setStrokeWidth(4); //画笔宽度
		mPaint.setStyle(Paint.Style.STROKE);
		mPath.reset();
		//起点
		mPath.moveTo(0, getHeight() / 2);
		//mPath
		//间距
		float mSpace = (float) getWidth() / 8;
		mPath.cubicTo(50, getHeight() / 2 - 10, 100, getHeight() / 2 + 10, 150, getHeight() / 2);
		//画path
		canvas.drawPath(mPath, mPaint);
		//画控制点
//		canvas.drawPoint(assistPoint1.x, assistPoint1.y, mPaint);
//		canvas.drawPoint(assistPoint2.x, assistPoint2.y, mPaint);
//
//		//画线
//		canvas.drawLine(startPoint.x, startPoint.y, assistPoint1.x, assistPoint1.y, mPaint);
//		canvas.drawLine(endPoint.x, endPoint.y, assistPoint2.x, assistPoint2.y, mPaint);
//		canvas.drawLine(assistPoint1.x, assistPoint1.y, assistPoint2.x, assistPoint2.y, mPaint);
	}
}
