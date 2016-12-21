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
	@PrimaryKey
	private String date;

}
