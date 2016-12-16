package com.k.xdiary.utils;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Administrator on 2016/12/15.
 */

public class HttpUtils {

	public static void getAsynHttp(String url, String[] keys, String[] values, final Handler handler) {
		OkHttpClient mOkHttpClient = new OkHttpClient();
		StringBuilder stringBuilder = new StringBuilder(url);
		stringBuilder.append("?");
		if (keys != null && values != null) {
			if (keys != null && values != null) {
				for (int i = 0; i < keys.length; i++) {
					stringBuilder.append(keys[i]).append("=").append(values[i]).append("&");
				}
			}
		}
		Request.Builder requestBuilder = new Request.Builder().url(stringBuilder.toString());
		//可以省略，默认是GET请求
		requestBuilder.method("GET", null);
		Request request = requestBuilder.build();
		okhttp3.Call mcall = mOkHttpClient.newCall(request);
		mcall.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {

			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				Message message=new Message();
				message.obj=response.body().string();
				handler.sendMessage(message);
			}
		});
	}

}
