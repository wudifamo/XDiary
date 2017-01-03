package com.k.xdiary.bean;

import io.realm.RealmObject;

/**
 * Created by Administrator on 2017/1/3.
 */

public class NoteBean extends RealmObject {

	private String title;
	private String content;
	private String pwd;

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
