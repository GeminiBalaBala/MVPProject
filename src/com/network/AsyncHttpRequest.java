package com.network;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import java.util.Map;

/**
 *  真正发送请求的类
 * @author liyao
 *
 */
public class AsyncHttpRequest {

	private static final String CONTENTTYPE = "Content-Type";
	private static final String HTTPHEAD = "application/x-www-form-urlencoded;charset=utf-8";
	//private static AsyncHttpClient client = new AsyncHttpClient();
	private static AsyncHttpClient client;
	
	public static final String HTTP_GET_TAG = "GET_Request";
	public static final String HTTP_POST_TAG = "POST_Request";

	private static AsyncHttpClient getClient() {
		if (client == null) {
			client = new AsyncHttpClient();
			client.setTimeout(5 * 1000);
			client.addHeader(CONTENTTYPE, HTTPHEAD);
		}
		return client;
	}

	private AsyncHttpRequest() {
	}

	private static class AsyncHttpRequestInstance {
		private static AsyncHttpRequest instance = new AsyncHttpRequest();
	}

	public static AsyncHttpRequest getInstance() {
		return AsyncHttpRequestInstance.instance;
	}

	/**
	 * get
	 * @param urlString
	 * @param map
	 * @param res
	 */
	public void get(String urlString, Map<String, String> map, AsyncHttpResponseHandler res) {
		try {
			com.loopj.android.http.RequestParams params = new RequestParams(map);
			Log.i(HTTP_GET_TAG, HTTP_GET_TAG + "\r\n" + urlString + "\r\n" + params.toString());
			getClient().get(urlString, params, res);
		} catch (Exception e) {
			Log.w("AsyncHttpRequest_get", e.getMessage());
			
			//CommonToast.globalToast(context, WARNINGTEXT, false);
		}
	}

	/**
	 * post
	 * @param urlString
	 * @param map
	 * @param res
	 */
	public void post(String urlString, Map<String, String> map, AsyncHttpResponseHandler res) {
		try {
			com.loopj.android.http.RequestParams params = new RequestParams(map);
			Log.i(HTTP_POST_TAG, HTTP_POST_TAG + "\r\n" + urlString + "\r\n" + params.toString());
			getClient().post(urlString, params, res);
		} catch (Exception e) {
			Log.w("AsyncHttpRequest_post", e.getMessage());
			
			//CommonToast.globalToast(context, WARNINGTEXT, false);
		}
		//org.apache.http.Header header = new BasicHeader(CONTENTTYPE, HTTPHEAD);
		//org.apache.http.Header[] headerArray = new org.apache.http.Header[] { header };
		//client.post(context, urlString, headerArray, params, HTTPHEAD, res);
	}

}
