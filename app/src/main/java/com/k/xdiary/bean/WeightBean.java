package com.k.xdiary.bean;

import com.k.xdiary.utils.BaseUtils;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2016/12/19.
 */

public class WeightBean extends RealmObject {

	private String weight;
	private int situp;
	private double run;
	private double sum;
	private String other;
	private int weather;
	private String tmp;
	@PrimaryKey
	private long date;

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void setSitup(int situp) {
		this.situp = situp;
	}

	public void setRun(double run) {
		this.run = run;
	}

	public int getSitup() {
		return situp;
	}

	public void setSitup(String situp) {
		if (situp.length() > 0) {
			this.situp = Integer.valueOf(situp);
		} else {
			this.situp = 0;
		}
	}

	public double getRun() {
		return run;
	}

	public void setRun(String run) {
		if (run.length() > 0) {
			this.run = Double.valueOf(run);
		} else {
			this.run = 0;
		}
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public long getDate() {
		return date;
	}

	public String getStringDate() {
		return BaseUtils.date2string(new Date(date));
	}

	public String getEnDate() {

		return BaseUtils.date2stringEn(new Date(date));
	}

	public void setDate(String date) {

		this.date = BaseUtils.string2date(date).getTime();
	}
}
