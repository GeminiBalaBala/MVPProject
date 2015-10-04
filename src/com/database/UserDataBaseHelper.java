package com.database;


import android.util.Log;
import com.bean.User;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

public class UserDataBaseHelper {
	private UserDataBaseHelper() {
	}

	private static class UserDataBaseHelperInstance {
		private static UserDataBaseHelper instance = new UserDataBaseHelper();
	}

	public static UserDataBaseHelper getInstance() {
		return UserDataBaseHelperInstance.instance;
	}

	/**
	 * ±£´æuser
	 * @param user
	 */
	public void putUserNotifiUI(User user) {
		DbUtils dbUtils = DBUtils.getDBUtils();
		try {
			dbUtils.createTableIfNotExist(User.class);
			dbUtils.saveOrUpdate(user);
			//MyApplication.getInstance().getApplicationContext().getContentResolver().notifyChange(uri, null);
		} catch (DbException e) {
			Log.w("UserDataBaseHelper", e.getMessage());
		} catch (Exception e) {
			Log.w("UserDataBaseHelper", e.getMessage());
		}
	}
}
