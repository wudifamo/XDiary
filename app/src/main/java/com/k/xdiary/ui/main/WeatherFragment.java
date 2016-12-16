package com.k.xdiary.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.k.xdiary.R;
import com.k.xdiary.base.BaseFragment;
import com.k.xdiary.bean.WeatherBean;
import com.k.xdiary.bean.WeatherBean.HeWeather5Bean.DailyForecastBean;
import com.k.xdiary.utils.BaseUtils;
import com.k.xdiary.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class WeatherFragment extends BaseFragment {

	private MainActivity mainActivity;
	private LineChartView mChart;
	private RecyclerView recyclerView;

	public WeatherFragment() {
		// Required empty public constructor
	}

	@Override
	protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mContext = getContext();
		mainActivity = (MainActivity) mContext;
		View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
		recyclerView = (RecyclerView) rootView.findViewById(R.id.weather_recyclerview);
		LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
		//设置布局管理器
		recyclerView.setLayoutManager(layoutManager);
		//设置为垂直布局，这也是默认的
		layoutManager.setOrientation(OrientationHelper.VERTICAL);
		recyclerView.setHasFixedSize(true);
		//设置分隔线
		//recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
		//设置增加或删除条目的动画
		//recyclerView.setItemAnimator(new DefaultItemAnimator());
		return rootView;
	}

	@Override
	protected void initData() {
//		HttpUtils.getAsynHttp("https://free-api.heweather.com/v5/weather", new String[]{"city", "key"}, new String[]{"杭州", MY_WEATHER_KEY},
//				handler);
		Message ms = new Message();
		ms.obj = "{\"HeWeather5\":[{\"aqi\":{\"city\":{\"aqi\":\"64\",\"co\":\"2\",\"no2\":\"48\",\"o3\":\"25\",\"pm10\":\"70\",\"pm25\":\"45\"," +
				"\"qlty\":\"良\",\"so2\":\"111\"}},\"basic\":{\"city\":\"大连\",\"cnty\":\"中国\",\"id\":\"CN101070201\",\"lat\":\"38.944000\"," +
				"\"lon\":\"121.576000\",\"update\":{\"loc\":\"2016-12-16 09:51\",\"utc\":\"2016-12-16 01:51\"}}," +
				"\"daily_forecast\":[{\"astro\":{\"mr\":\"19:15\",\"ms\":\"08:48\",\"sr\":\"07:05\",\"ss\":\"16:32\"}," +
				"\"cond\":{\"code_d\":\"100\"," +
				"\"code_n\":\"100\",\"txt_d\":\"晴\",\"txt_n\":\"晴\"},\"date\":\"2016-12-16\",\"hum\":\"55\",\"pcpn\":\"0.0\",\"pop\":\"0\"," +
				"\"pres\":\"1027\",\"tmp\":{\"max\":\"6\",\"min\":\"-3\"},\"uv\":\"2\",\"vis\":\"10\",\"wind\":{\"deg\":\"260\",\"dir\":\"西南风\"," +
				"\"sc\":\"5-6\",\"spd\":\"31\"}},{\"astro\":{\"mr\":\"20:19\",\"ms\":\"09:38\",\"sr\":\"07:06\",\"ss\":\"16:33\"}," +
				"\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2016-12-17\",\"hum\":\"64\"," +
				"\"pcpn\":\"0.0\",\"pop\":\"0\",\"pres\":\"1025\",\"tmp\":{\"max\":\"8\",\"min\":\"2\"},\"uv\":\"2\",\"vis\":\"10\"," +
				"\"wind\":{\"deg\":\"241\",\"dir\":\"西南风\",\"sc\":\"4-5\",\"spd\":\"17\"}},{\"astro\":{\"mr\":\"21:24\",\"ms\":\"10:21\"," +
				"\"sr\":\"07:07\",\"ss\":\"16:33\"},\"cond\":{\"code_d\":\"100\",\"code_n\":\"100\",\"txt_d\":\"晴\",\"txt_n\":\"晴\"}," +
				"\"date\":\"2016-12-18\",\"hum\":\"69\",\"pcpn\":\"0.0\",\"pop\":\"0\",\"pres\":\"1025\",\"tmp\":{\"max\":\"8\",\"min\":\"3\"}," +
				"\"uv\":\"2\",\"vis\":\"10\",\"wind\":{\"deg\":\"208\",\"dir\":\"西南风\",\"sc\":\"4-5\",\"spd\":\"23\"}}," +
				"{\"astro\":{\"mr\":\"22:25\"," +
				"\"ms\":\"10:59\",\"sr\":\"07:07\",\"ss\":\"16:34\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\"," +
				"\"txt_n\":\"多云\"},\"date\":\"2016-12-19\",\"hum\":\"71\",\"pcpn\":\"0.0\",\"pop\":\"0\",\"pres\":\"1024\",\"tmp\":{\"max\":\"8\"," +
				"\"min\":\"1\"},\"uv\":\"2\",\"vis\":\"10\",\"wind\":{\"deg\":\"285\",\"dir\":\"西南风\",\"sc\":\"4-5\",\"spd\":\"22\"}}," +
				"{\"astro\":{\"mr\":\"23:25\",\"ms\":\"11:33\",\"sr\":\"07:08\",\"ss\":\"16:34\"},\"cond\":{\"code_d\":\"100\",\"code_n\":\"100\"," +
				"\"txt_d\":\"晴\",\"txt_n\":\"晴\"},\"date\":\"2016-12-20\",\"hum\":\"65\",\"pcpn\":\"0.0\",\"pop\":\"0\",\"pres\":\"1025\"," +
				"\"tmp\":{\"max\":\"8\",\"min\":\"-2\"},\"uv\":\"2\",\"vis\":\"10\",\"wind\":{\"deg\":\"254\",\"dir\":\"北风\",\"sc\":\"5-6\"," +
				"\"spd\":\"29\"}},{\"astro\":{\"mr\":\"null\",\"ms\":\"12:03\",\"sr\":\"07:08\",\"ss\":\"16:34\"},\"cond\":{\"code_d\":\"101\"," +
				"\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2016-12-21\",\"hum\":\"60\",\"pcpn\":\"0.0\",\"pop\":\"0\"," +
				"\"pres\":\"1027\",\"tmp\":{\"max\":\"4\",\"min\":\"-3\"},\"uv\":\"-999\",\"vis\":\"10\",\"wind\":{\"deg\":\"336\"," +
				"\"dir\":\"西南风\"," +
				"\"sc\":\"4-5\",\"spd\":\"19\"}},{\"astro\":{\"mr\":\"00:22\",\"ms\":\"12:33\",\"sr\":\"07:09\",\"ss\":\"16:35\"}," +
				"\"cond\":{\"code_d\":\"100\",\"code_n\":\"401\",\"txt_d\":\"晴\",\"txt_n\":\"中雪\"},\"date\":\"2016-12-22\",\"hum\":\"58\"," +
				"\"pcpn\":\"0.0\",\"pop\":\"0\",\"pres\":\"1024\",\"tmp\":{\"max\":\"3\",\"min\":\"-5\"},\"uv\":\"-999\",\"vis\":\"10\"," +
				"\"wind\":{\"deg\":\"348\",\"dir\":\"北风\",\"sc\":\"5-6\",\"spd\":\"33\"}}],\"hourly_forecast\":[{\"cond\":{\"code\":\"100\"," +
				"\"txt\":\"晴\"},\"date\":\"2016-12-16 10:00\",\"hum\":\"52\",\"pop\":\"0\",\"pres\":\"1028\",\"tmp\":\"4\"," +
				"\"wind\":{\"deg\":\"277\",\"dir\":\"西南风\",\"sc\":\"4-5\",\"spd\":\"29\"}},{\"cond\":{\"code\":\"100\",\"txt\":\"晴\"}," +
				"\"date\":\"2016-12-16 13:00\",\"hum\":\"58\",\"pop\":\"0\",\"pres\":\"1026\",\"tmp\":\"5\",\"wind\":{\"deg\":\"267\"," +
				"\"dir\":\"西南风\",\"sc\":\"5-6\",\"spd\":\"35\"}},{\"cond\":{\"code\":\"100\",\"txt\":\"晴\"},\"date\":\"2016-12-16 16:00\"," +
				"\"hum\":\"61\",\"pop\":\"0\",\"pres\":\"1024\",\"tmp\":\"5\",\"wind\":{\"deg\":\"258\",\"dir\":\"西南风\",\"sc\":\"4-5\"," +
				"\"spd\":\"36\"}},{\"cond\":{\"code\":\"100\",\"txt\":\"晴\"},\"date\":\"2016-12-16 19:00\",\"hum\":\"58\",\"pop\":\"0\"," +
				"\"pres\":\"1024\",\"tmp\":\"1\",\"wind\":{\"deg\":\"255\",\"dir\":\"西南风\",\"sc\":\"4-5\",\"spd\":\"36\"}}," +
				"{\"cond\":{\"code\":\"100\",\"txt\":\"晴\"},\"date\":\"2016-12-16 22:00\",\"hum\":\"58\",\"pop\":\"0\",\"pres\":\"1023\"," +
				"\"tmp\":\"0\",\"wind\":{\"deg\":\"258\",\"dir\":\"西南风\",\"sc\":\"5-6\",\"spd\":\"35\"}}],\"now\":{\"cond\":{\"code\":\"101\"," +
				"\"txt\":\"多云\"},\"fl\":\"-1\",\"hum\":\"53\",\"pcpn\":\"0\",\"pres\":\"1029\",\"tmp\":\"2\",\"vis\":\"7\"," +
				"\"wind\":{\"deg\":\"140\",\"dir\":\"西南风\",\"sc\":\"4-5\",\"spd\":\"20\"}},\"status\":\"ok\"," +
				"\"suggestion\":{\"air\":{\"brf\":\"优\"," +
				"\"txt\":\"气象条件非常有利于空气污染物稀释、扩散和清除，可在室外正常活动。\"},\"comf\":{\"brf\":\"较不舒适\",\"txt\":\"白天天气较凉，且风力较强，您会感觉偏冷，不很舒适，请注意添加衣物，以防感冒。\"}," +
				"\"cw\":{\"brf\":\"较不宜\",\"txt\":\"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。\"},\"drsg\":{\"brf\":\"冷\"," +
				"\"txt\":\"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。\"},\"flu\":{\"brf\":\"极易发\"," +
				"\"txt\":\"昼夜温差极大，且风力较强，极易发生感冒，请特别注意增减衣服保暖防寒。\"},\"sport\":{\"brf\":\"较不宜\",\"txt\":\"天气较好，但考虑风力很大，推荐您进行室内运动，若在户外运动请注意避风保暖和防晒。\"}," +
				"\"trav\":{\"brf\":\"较不宜\",\"txt\":\"天气较好，稍凉加之风大，可能对您的出行产生一定的影响，出游时记得带上防风衣物。\"},\"uv\":{\"brf\":\"中等\"," +
				"\"txt\":\"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。\"}}}]}";
		handler.sendMessage(ms);
	}

	@Override
	protected void setDefaultFragmentTitle(String title) {

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
				mainActivity.currentAqi = ViewUtils.colorMap.get(aqiBean.getQlty());
				mainActivity.setQualityColor();
				mainActivity.main_qualities.setText("AQI " + aqiBean.getAqi() + "\n" + "PM2.5 " + aqiBean.getPm25());
				setChart(weather5Bean.getDaily_forecast());
				Snackbar.make(recyclerView, "connection success", Snackbar.LENGTH_LONG).setAction("retry", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//tv.setText("aleady click snackbar");
					}
				}).show();
			} else {
				Snackbar.make(recyclerView, "connection error", Snackbar.LENGTH_LONG).setAction("retry", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//tv.setText("aleady click snackbar");
					}
				}).show();
			}
		}
	};

	private void setChart(List<DailyForecastBean> dailyList) {
		View view = View.inflate(mContext, R.layout.card_temp, null);
		view.setLayoutParams(new DrawerLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, BaseUtils.dip2px(mContext, 100)));
		mChart = (LineChartView) view.findViewById(R.id.weather_chart);
		QuickAdapter mQuickAdapter = new QuickAdapter(mContext, dailyList);
		mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		mQuickAdapter.addHeaderView(view);
		recyclerView.setAdapter(mQuickAdapter);
		List<PointValue> values = new ArrayList<PointValue>();
		List<AxisValue> mAxisValues = new ArrayList<AxisValue>();
		for (int i = 0; i < dailyList.size(); i++) {
			DailyForecastBean dailyForecastBean = dailyList.get(i);
			values.add(new PointValue(i, Float.parseFloat(dailyForecastBean.getTmp().getMax())));
			mAxisValues.add(new AxisValue(i).setLabel(dailyForecastBean.getDate().substring(dailyForecastBean.getDate().lastIndexOf("-") + 1)));
		}
		Line line = new Line(values);
		line.setColor(Color.WHITE);
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
