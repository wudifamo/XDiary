package com.k.xdiary.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2016/12/19.
 */

public class WeightBean extends RealmObject {

	private double weight;
	private int situp;
	private double run;
	private double sum;
	private String other;
	@PrimaryKey
	private String date;

	public double getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		if (weight.length() > 0) {
			this.weight = Double.valueOf(weight);
		} else {
			this.weight = 0;
		}
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
