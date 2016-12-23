package com.k.xdiary.dao;

import com.k.xdiary.bean.WeightBean;

import java.math.BigDecimal;
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
		RealmResults<WeightBean> lasts = mRealm.where(WeightBean.class).lessThan("date", weightBean.getDate()).findAllSorted("date", Sort
				.DESCENDING);
		double sum = 0;
		if (lasts.size() > 0) {
			WeightBean lastWeight = lasts.get(0);
			sum = getSum(weightBean.getWeight(), lastWeight.getWeight());
		}

		WeightBean tWeight = mRealm.where(WeightBean.class).greaterThan("date", weightBean.getDate()).findFirst();

		mRealm.beginTransaction();
		weightBean.setSum(sum);
		mRealm.copyToRealmOrUpdate(weightBean);

		if (tWeight != null) {
			tWeight.setSum(getSum(tWeight.getWeight(), weightBean.getWeight()));
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
	public static double deleteWeight(long date) {
		Realm mRealm = Realm.getDefaultInstance();
		WeightBean weightBean = mRealm.where(WeightBean.class).equalTo("date", date).findFirst();
		WeightBean tWeight = mRealm.where(WeightBean.class).greaterThan("date", date).findFirst();
		RealmResults<WeightBean> lasts = mRealm.where(WeightBean.class).lessThan("date", date).findAllSorted("date", Sort
				.DESCENDING);
		double sum = 0;
		if (tWeight != null && lasts.size() > 0) {
			WeightBean lastWeight = lasts.get(0);
			sum = getSum(tWeight.getWeight(), lastWeight.getWeight());
		}
		mRealm.beginTransaction();
		weightBean.deleteFromRealm();
		if (tWeight != null) {
			tWeight.setSum(sum);
		}
		mRealm.commitTransaction();
		return sum;
	}

	public static <E extends RealmModel> RealmResults<E> queryAll(Class<E> eClass) {
		Realm mRealm = Realm.getDefaultInstance();
		RealmResults<E> weightList = mRealm.where(eClass).findAll();
		weightList = weightList.sort("date", Sort.DESCENDING);
		return weightList;
	}

	//////从查询的所有数据中取出需要的。(脱离Realm的控制)
	public static <E extends RealmModel> List<E> getLimitList(RealmResults<E> data, int currentPage, int limit) {
		int offset = currentPage * limit;
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

	public static double getSum(String arg1, String arg2) {
		BigDecimal a1 = new BigDecimal(arg1);
		BigDecimal b1 = new BigDecimal(arg2);
		return a1.subtract(b1).doubleValue();
	}

}
