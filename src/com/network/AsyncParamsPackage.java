package com.network;

import java.util.Map;

/**
 * ����http�Ĺ�������
 * @author liyao
 *
 */
public class AsyncParamsPackage {

	private AsyncParamsPackage() {
	}

	private static class AsyncParamsPackageInstance {
		private static AsyncParamsPackage instance = new AsyncParamsPackage();
	}

	public static AsyncParamsPackage getInstance() {
		return AsyncParamsPackageInstance.instance;
	}
	
	public Map<String, String> loginPackage(Map<String, String> params) {
		return getMD5(params);
	}
	
	/**
	 * ����md5,ʡ������
	 * @param params
	 * @return
	 */
	public Map<String, String> getMD5(Map<String, String> params) {
		return params;
	}
	


	
}
