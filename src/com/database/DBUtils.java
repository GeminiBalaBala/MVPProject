package com.database;

import android.content.Context;
import android.util.Log;

import com.application.MyApplication;
import com.lidroid.xutils.DbUtils;

public class DBUtils {
	
	private static DbUtils dbUtils;

	private static DbUtils.DbUpgradeListener dbUpgradeListener = new DbUtils.DbUpgradeListener() {
		@Override
		public void onUpgrade(DbUtils dbUtils, int i, int i2) {
			
		}
	};
	
	/**
	 * ≥ı ºªØ
	 *
	 * @param context
	 * @return
	 */
	public static DbUtils getDBUtils() {
		if (dbUtils == null) {
			try {
				Context context = MyApplication.getInstance();
				dbUtils = DbUtils.create(context, "testDB", 1, dbUpgradeListener);
				dbUtils.configAllowTransaction(true);
				dbUtils.configDebug(true);
			} catch (Exception e) {
				Log.w("DBUtils", e.getMessage());
			}
		}
		return dbUtils;
	}

}
