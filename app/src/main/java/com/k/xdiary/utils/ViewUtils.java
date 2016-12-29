package com.k.xdiary.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.k.xdiary.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public static int getWeatherIcon(String wStr) {
		if (wStr.contains("雷")) {
			return R.drawable.weather_thunder;
		} else if (wStr.contains("阴") || wStr.contains("云")) {
			return R.drawable.weather_cloud;
		} else if (wStr.contains("雨")) {
			return R.drawable.weather_rain;
		} else if (wStr.contains("雪")) {
			return R.drawable.weather_snow;
		} else if (wStr.contains("雾") || wStr.contains("霾")) {
			return R.drawable.weather_pm;
		} else {
			return R.drawable.weather_sunny;
		}
	}

	public static Bitmap getLoacalBitmap(String url) {
		if (url == null) {
			return null;
		}
		try {
			url = url.replace("file://", "");
			FileInputStream fis = new FileInputStream(url);
			return BitmapFactory.decodeStream(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void getFrescoController(SimpleDraweeView imgIv, String uri, int width, int height) {
		if (uri != null) {
			ImageRequest request = ImageRequestBuilder
					.newBuilderWithSource(Uri.parse(uri))
					.setResizeOptions(new ResizeOptions(width, height))
					.build();
			AbstractDraweeController controller = Fresco.newDraweeControllerBuilder().setOldController(imgIv.getController()).setImageRequest
					(request)
					.build();
			imgIv.setController(controller);
		}
	}

}
