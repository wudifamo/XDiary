package com.k.xdiary.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2016/12/21.
 */

public class DiaryBean extends RealmObject {

	private String title;
	private String content;
	private String imgUrl;
	private String tmp;
	private String weather;
	private String date;
	@PrimaryKey
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl =  imgUrl;
	}

	public String getTmp() {
		return tmp;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
