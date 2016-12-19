package com.k.xdiary;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2016/12/19.
 */

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		// The Realm file will be located in Context.getFilesDir() with name "default.realm"
		Realm.init(this);
		RealmConfiguration config = new  RealmConfiguration.Builder()
				.name("xdiary.realm")
				.deleteRealmIfMigrationNeeded()
				.build();
		Realm.setDefaultConfiguration(config);
	}
}
