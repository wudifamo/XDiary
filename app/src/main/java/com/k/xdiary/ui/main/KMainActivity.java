package com.k.xdiary.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.florent37.viewanimator.ViewAnimator;
import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;
import com.k.xdiary.bean.WeatherBean;
import com.k.xdiary.ui.diary.DiaryActivity;
import com.k.xdiary.ui.weight.WeightActivity;
import com.k.xdiary.utils.BaseUtils;
import com.k.xdiary.utils.HttpUtils;
import com.k.xdiary.utils.ViewUtils;
import com.k.xdiary.views.MainParalView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

import static com.k.xdiary.utils.HttpUtils.SEE_WEATHER_KEY;
import static com.k.xdiary.utils.HttpUtils.textWeatherStr;

public class KMainActivity extends BaseActivity {

	private FrameLayout activity_kmain;
	MainParalView mpv0, mpv1, mpv2;
	private int mWidth, mHeight;
	private TextView main_qualities;
	private LineChartView mChart;

	@Override
	public void initParms(Bundle parms) {

	}

	@Override
	public int bindLayout() {
		return R.layout.activity_kmain;
	}

	@Override
	public void initView(View view) {
		mSwipeBackLayout.setEnableGesture(false);
		activity_kmain = (FrameLayout) findViewById(R.id.activity_kmain);
		main_qualities = (TextView) findViewById(R.id.main_qualities_tv);
		mChart = (LineChartView) view.findViewById(R.id.weather_chart);
		activity_kmain.setOnClickListener(this);
		WindowManager manager = this.getWindowManager();
		DisplayMetrics outMetrics = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(outMetrics);
		mWidth = outMetrics.widthPixels;
		mHeight = outMetrics.heightPixels;
		mpv0 = (MainParalView) findViewById(R.id.main_mpv0);
		mpv1 = (MainParalView) findViewById(R.id.main_mpv1);
		mpv2 = (MainParalView) findViewById(R.id.main_mpv2);
		mpv0.setOnClickListener(this);
		mpv1.setOnClickListener(this);
		mpv2.setOnClickListener(this);
	}

	@Override
	public void doBusiness() {
		HttpUtils.getAsynHttp("https://free-api.heweather.com/v5/weather", new String[]{"city", "key"}, new String[]{"杭州", SEE_WEATHER_KEY},
				handler);
		Message ms = new Message();
		ms.obj = textWeatherStr;
		//handler.sendMessage(ms);
	}

	@Override
	public void widgetClick(View v) {
		switch (v.getId()) {
			case R.id.main_mpv0:
				startActivity(WeightActivity.class);
				break;
			case R.id.main_mpv1:
				startActivity(DiaryActivity.class);
				break;
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		ViewAnimator.animate(mpv0)
				.translationX(-mWidth * 1.3f)
				.translationY(mWidth * 1.3f)
				.interpolator(new OvershootInterpolator())
				.startDelay(200)
				.duration(700)
				.start();
		ViewAnimator.animate(mpv1).translationX(-mWidth * 1.3f)
				.translationY(mWidth * 1.3f)
				.interpolator(new OvershootInterpolator())
				.duration(700)
				.andAnimate(mpv2)
				.startDelay(400)
				.start();
		ViewAnimator.animate(mpv2).translationX(-mWidth * 1.3f)
				.translationY(mWidth * 1.3f)
				.interpolator(new OvershootInterpolator())
				.duration(700)
				.andAnimate(mpv2)
				.startDelay(600)
				.start();
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			String result = msg.obj.toString();
			WeatherBean weatherBean = gson.fromJson(result, WeatherBean.class);
			if (weatherBean.getHeWeather5() != null && weatherBean.getHeWeather5().size() > 0 && weatherBean.getHeWeather5().get(0).getStatus()
					.equals("ok")) {
				WeatherBean.HeWeather5Bean weather5Bean = weatherBean.getHeWeather5().get(0);
				WeatherBean.HeWeather5Bean.AqiBean.CityBean aqiBean = weather5Bean.getAqi().getCity();
				main_qualities.setTextColor(Color.parseColor("#" + ViewUtils.colorMap.get(aqiBean.getQlty())));
				TextView tmpTv = (TextView) findViewById(R.id.main_tmp_tv);
				TextView tmpmmTv = (TextView) findViewById(R.id.main_tmpmm_tv);
				tmpTv.setText(weather5Bean.getNow().getTmp() + "℃");
				List<WeatherBean.HeWeather5Bean.DailyForecastBean> listDaily = weather5Bean.getDaily_forecast();
				WeatherBean.HeWeather5Bean.DailyForecastBean.TmpBean tmpBean = listDaily.get(0).getTmp();
				tmpmmTv.setText(tmpBean.getMax() + "/" + tmpBean.getMin());
				main_qualities.setText("AQI " + aqiBean.getAqi() + "\n" + "PM2.5 " + aqiBean.getPm25());
				BaseUtils.saveTodayTmp(mContext, weather5Bean.getNow().getCond().getTxt(), tmpBean.getMax());
				setChart(weather5Bean.getDaily_forecast());

				ViewAnimator.animate(findViewById(R.id.main_tmp_rl))
						.dp().translationY(165)
						.interpolator(new OvershootInterpolator())
						.duration(500)
						.start();
				ViewAnimator.animate(mChart)
						.dp().translationY(-110)
						.interpolator(new OvershootInterpolator())
						.duration(500)
						.start();
			} else {
				Snackbar.make(findViewById(R.id.activity_kmain), "connection error", Snackbar.LENGTH_LONG).setAction("retry", new View
						.OnClickListener() {
					@Override
					public void onClick(View v) {
						//tv.setText("aleady click snackbar");
					}
				}).show();
			}
		}
	};

	private void setChart(List<WeatherBean.HeWeather5Bean.DailyForecastBean> dailyList) {
		List<PointValue> values = new ArrayList<PointValue>();
		List<AxisValue> mAxisValues = new ArrayList<AxisValue>();
		for (int i = 0; i < dailyList.size(); i++) {
			WeatherBean.HeWeather5Bean.DailyForecastBean dailyForecastBean = dailyList.get(i);
			values.add(new PointValue(i, Float.parseFloat(dailyForecastBean.getTmp().getMax())));
			mAxisValues.add(new AxisValue(i).setLabel(dailyForecastBean.getDate().substring(dailyForecastBean.getDate().lastIndexOf("-") + 1)));
		}
		Line line = new Line(values);
		line.setColor(Color.BLACK);
		line.setStrokeWidth(1);
		line.setCubic(true);
		line.setHasPoints(false);
		List<Line> lines = new ArrayList<Line>();
		lines.add(line);
		LineChartData data = new LineChartData();
		data.setLines(lines);

		Axis axisX = new Axis();
		axisX.setValues(mAxisValues);
		axisX.setHasSeparationLine(false);
		data.setAxisXBottom(axisX);


		data.setBaseValue(Float.NEGATIVE_INFINITY);
		mChart.setLineChartData(data);
		final Viewport v = new Viewport(mChart.getMaximumViewport());
		v.left = -1;                             //坐标原点在左下
		v.bottom = v.bottom - 7;
		v.top = v.top + 7;                            //最高点为100
		v.right = v.right + 1;           //右边为点 坐标从0开始 点号从1 需要 -1
		mChart.setMaximumViewport(v);   //给最大的视图设置 相当于原图
		mChart.setInteractive(false);
//		mChart.setCurrentViewport(v);
		mChart.setCurrentViewportWithAnimation(v);
	}
}
