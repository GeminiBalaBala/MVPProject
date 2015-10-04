package com.network;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 封装请求参数的工具类
 */
public class AsyncRequestParams {

	private AsyncRequestParams() {
	}

	private static class RequestParamsInstance {
		private static AsyncRequestParams instance = new AsyncRequestParams();
	}

	public static AsyncRequestParams getInstance() {
		return RequestParamsInstance.instance;
	}


	/**
	 * login
	 *
	 * @param userId
	 * @param pwd
	 * @param pushToken
	 * @return
	 */
	public Map<String, String> getLogin(String userId, String pwd, String pushToken) {
		Map<String, String> result = new HashMap<>();
		result.put("tel", userId);
		result.put("password", pwd);
		result.put("push_token", pushToken);
		return result;
	}
}
