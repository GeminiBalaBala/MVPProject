package com.application;

import android.app.Application;

public class MyApplication extends Application {
	private static MyApplication instance;

	public static MyApplication getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = MyApplication.this;
		//initAPPVersion();
	}

	/*private void initAPPVersion() {
		UtilSP.putStrSP(getApplicationContext(), SPAttribute.APP_VERSION, getVersion());
	}*/

	/*private String getVersion() {
		PackageManager pm = getInstance().getApplicationContext().getPackageManager();
		try {
			PackageInfo packageInfo = pm.getPackageInfo(getInstance().getApplicationContext().getPackageName(), 0);
			return packageInfo.versionName;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
			return "";
		}
	}*/
	
	/*public static String getUid() {
		return UtilSP.getStrSP(getInstance().getApplicationContext(), SPAttribute.APP_UID, "");
	}*/
	
}
