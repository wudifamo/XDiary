package com.k.xdiary;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by Administrator on 2016/12/19.
 */

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		// The Realm file will be located in Context.getFilesDir() with name "default.realm"
		Realm.init(this);
		RealmConfiguration config = new RealmConfiguration.Builder()
				.name("xdiary")
				.deleteRealmIfMigrationNeeded()
//				.schemaVersion(0)
//				.migration(new MyMigration())
				.build();
		Realm.setDefaultConfiguration(config);
		ImagePipelineConfig frescoConfig = ImagePipelineConfig.newBuilder(this)
				.setDownsampleEnabled(true).build();
		Fresco.initialize(this, frescoConfig);
	}

	public class MyMigration implements RealmMigration {
		@Override
		public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
			RealmSchema schema = realm.getSchema();
			if (oldVersion == 0) {
//				schema.create("Dog")
//						.addField("name", String.class)
//						.addField("age", int.class);
				schema.get("WeightBean")
						.addField("weather", String.class);
				oldVersion++;
			}
		}
	}

}
