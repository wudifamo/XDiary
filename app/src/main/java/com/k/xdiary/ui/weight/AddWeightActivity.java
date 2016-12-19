package com.k.xdiary.ui.weight;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.k.xdiary.R;
import com.k.xdiary.base.BaseActivity;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class AddWeightActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener {

    private TextView dateTv;
    private Calendar now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initParms(Bundle parms) {
        now = Calendar.getInstance();
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_add_weight;
    }

    @Override
    public void initView(View view) {
        dateTv = (TextView) findViewById(R.id.addweather_datetv);
    }

    @Override
    public void doBusiness() {
        findViewById(R.id.addweather_dateCv).setOnClickListener(this);
        dateTv.setText(now.get(Calendar.YEAR) + "-" + now.get(Calendar.MONTH) + "-" + now.get(Calendar.DAY_OF_MONTH));

    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.addweather_dateCv:
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        AddWeightActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setVersion(DatePickerDialog.Version.VERSION_1);
                dpd.show(getFragmentManager(), "Datepickerdialog");
                break;
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        dateTv.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
    }
}
