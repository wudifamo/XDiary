package com.k.xdiary.utils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/15.
 */

public class ViewUtils {

	public static String[] qualityColor = new String[]{"47d341", "d4d200", "ffff00", "ff7d00", "961bad", "7e0123"};
	public static HashMap<String, String> colorMap = new HashMap<String, String>() {
		{
			put("优", "47d341");
			put("良", "d4d200");
			put("轻度污染", "ffff00");
			put("中度污染", "ff7d00");
			put("重度污染", "961bad");
			put("严重污染", "7e0123");
		}
	};


}
