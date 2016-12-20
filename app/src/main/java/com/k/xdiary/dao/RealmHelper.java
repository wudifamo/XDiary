package com.k.xdiary.dao;

import com.k.xdiary.bean.WeightBean;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Administrator on 2016/12/20.
 */

public class RealmHelper {

	/**
	 * add （增）
	 */
	public static void addWeight(WeightBean weightBean) {
		Realm mRealm = Realm.getDefaultInstance();
		WeightBean sweight = mRealm.where(WeightBean.class).equalTo("date", weightBean.getDate()).findFirst();
		mRealm.beginTransaction();
		if (sweight != null) {
			sweight.setWeight(String.valueOf(weightBean.getWeight()));
			sweight.setOther(String.valueOf(weightBean.getOther()));
			sweight.setRun(String.valueOf(weightBean.getRun()));
			sweight.setSitup(String.valueOf(weightBean.getSitup()));
		} else {
			mRealm.copyToRealm(weightBean);
		}
		mRealm.commitTransaction();
	}

	/**
	 * query （查询所有）
	 */
	public static List<WeightBean> queryAllWeight() {
		Realm mRealm = Realm.getDefaultInstance();
		RealmResults<WeightBean> weightList = mRealm.where(WeightBean.class).findAll();
		/**
		 * 对查询结果，按Id进行排序，只能对查询结果进行排序
		 */
		//增序排列
//		weightList = weightList.sort("date");
//        //降序排列
		weightList = weightList.sort("date", Sort.DESCENDING);
		return mRealm.copyFromRealm(weightList);
	}

	/**
	 * delete （删）
	 */
	public static void deleteWeight(String date) {
		Realm mRealm = Realm.getDefaultInstance();
		WeightBean weightBean = mRealm.where(WeightBean.class).equalTo("date", date).findFirst();
		mRealm.beginTransaction();
		weightBean.deleteFromRealm();
		mRealm.commitTransaction();

	}

	//////从查询的所有数据中取出需要的。(脱离Realm的控制)
	public static <E extends RealmModel> List<E> getLimitList(RealmResults<E> data, int offset, int limit) {
		List<E> obtainList = new ArrayList();
		Realm realm = Realm.getDefaultInstance();
		if (data.size() == 0) {
			return obtainList;
		}
		for (int i = offset; i < offset + limit; i++) {
			if (i >= data.size()) {
				break;
			}
			E temp = realm.copyFromRealm(data.get(i));
			obtainList.add(temp);
		}
		realm.close();
		return obtainList;
	}

}
