package com.k.xdiary.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2016/12/19.
 */

public class WeightBean extends RealmObject {

	private String weight;
	private int situp;
	private String plank;
	private double sum;
	private String other;
	@PrimaryKey
	private String date;

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getSitup() {
		return situp;
	}

	public void setSitup(int situp) {
		this.situp = situp;
	}

	public String getPlank() {
		return plank;
	}

	public void setPlank(String plank) {
		this.plank = plank;
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
