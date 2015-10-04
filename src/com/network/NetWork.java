package com.network;

import java.util.Map;

import org.apache.http.Header;

import com.network.Interface.NetWorkListener;


/**
 * 此处的做法是将model与网络分离
 * @author liyao
 *
 */
public class NetWork {

	private NetWork() {
	}

	private static class NetWorkInstance {
		private static NetWork instance = new NetWork();
	}

	public static NetWork getInstance() {
		return NetWorkInstance.instance;
	}
	
	public void getNetWorkJson(String url,Map<String, String> params,final NetWorkListener netWorkListener) {
		
		AsyncHttpRequest.getInstance().post(url, params, new AsyncHttpResponse() {
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] bytes) {
				String httpResult = super.onSuccessStr(statusCode, headers, bytes);
				netWorkListener.netWorkSuccess(httpResult);
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, byte[] bytes, Throwable throwable) {
				super.onFailure(statusCode, headers, bytes, throwable);
				netWorkListener.netWorkError(statusCode + "");
			}
		});
	}
	
}
