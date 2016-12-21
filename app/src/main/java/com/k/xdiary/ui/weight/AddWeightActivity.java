package com.k.xdiary.ui.weight;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;
import com.k.xdiary.bean.WeightBean;
import com.k.xdiary.dao.RealmHelper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class AddWeightActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener {

	private EditText weightEt, sitEt, runEt, otherEt;
	private TextView dateTv;
	private DatePickerDialog dpd;
	private Button toolbar_btnRight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initParms(Bundle parms) {
		Calendar now = Calendar.getInstance();
		dpd = DatePickerDialog.newInstance(
				AddWeightActivity.this,
				now.get(Calendar.YEAR),
				now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH)
		);
		dpd.setVersion(DatePickerDialog.Version.VERSION_1);
		dpd.autoDismiss(true);
	}

	@Override
	public int bindLayout() {
		return R.layout.activity_add_weight;
	}

	@Override
	public void initView(View view) {
		dateTv = (TextView) findViewById(R.id.addweight_datetv);
		toolbar_btnRight = (Button) findViewById(R.id.toolbar_btnRight);
		weightEt = (EditText) findViewById(R.id.addweight_weight);
		sitEt = (EditText) findViewById(R.id.addweight_situp);
		runEt = (EditText) findViewById(R.id.addweight_run);
		otherEt = (EditText) findViewById(R.id.addweight_other);
	}

	@Override
	public void doBusiness() {
		findViewById(R.id.addweight_dateCv).setOnClickListener(this);
		dateTv.setText(formatDate(dpd.getSelectedDay().getYear(), dpd.getSelectedDay().getMonth(), dpd.getSelectedDay().getDay()));
		toolbar_btnRight.setText("done");
		toolbar_btnRight.setVisibility(View.VISIBLE);
		toolbar_btnRight.setOnClickListener(this);
	}

	@Override
	public void widgetClick(View v) {
		switch (v.getId()) {
			case R.id.addweight_dateCv:
				dpd.show(getFragmentManager(), "Datepickerdialog");
				break;
			case R.id.toolbar_btnRight:
				if (TextUtils.isEmpty(weightEt.getText().toString())) {
					weightEt.setError("can't null");
				} else {
					WeightBean weightBean = new WeightBean();
					weightBean.setDate(dateTv.getText().toString());
					weightBean.setWeight(weightEt.getText().toString());
					weightBean.setSitup(sitEt.getText().toString());
					weightBean.setRun(runEt.getText().toString());
					weightBean.setOther(otherEt.getText().toString());
					RealmHelper.addWeight(weightBean);
					setResult(1);
					finish();
				}
				break;
		}
	}

	@Override
	public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
		dateTv.setText(formatDate(year, monthOfYear, dayOfMonth));
	}

	private String formatDate(int year, int month, int day) {
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		sb.append("-");
		month++;
		if (month < 10) {
			sb.append("0");
		}
		sb.append(month).append("-");
		if (day < 10) {
			sb.append("0");
		}
		sb.append(day);
		return sb.toString();
	}
}
