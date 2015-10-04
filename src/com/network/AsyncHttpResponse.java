package com.network;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.io.UnsupportedEncodingException;

/**
 * Created by liyao.
 * AsyncHttpClient响应类
 */
public class AsyncHttpResponse extends AsyncHttpResponseHandler {

	private static final String CHARSET = "UTF-8";
	private Handler handler;
	private Context context;

	private int AsyncResponseSuc = 200;
	private int AsyncResponseErr = 500;

	public AsyncHttpResponse() {
	}

	public AsyncHttpResponse(Context context, Handler handler, int asyncResponseSuc, int asyncResponseErr) {
		this.context = context;
		this.handler = handler;
		this.AsyncResponseSuc = asyncResponseSuc;
		this.AsyncResponseErr = asyncResponseErr;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public int getAsyncResponseSuc() {
		return AsyncResponseSuc;
	}

	public void setAsyncResponseSuc(int asyncResponseSuc) {
		AsyncResponseSuc = asyncResponseSuc;
	}

	public int getAsyncResponseErr() {
		return AsyncResponseErr;
	}

	public void setAsyncResponseErr(int asyncResponseErr) {
		AsyncResponseErr = asyncResponseErr;
	}

	@Override
	public void onProgress(long bytesWritten, long totalSize) {
		super.onProgress(bytesWritten, totalSize);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onFinish() {
		super.onFinish();
	}

	@Override
	public void onSuccess(int statusCode, Header[] headers, byte[] bytes) {
		try {
			String result = new String(bytes, CHARSET);
			if (statusCode >= 200 && statusCode < 400 && !TextUtils.isEmpty(result)) {
				if (handler != null) {
					handler.obtainMessage(AsyncResponseSuc, result).sendToTarget();
				}
			}
				Log.w("AsyncHttpResponse_onSuccess_StatusCode", statusCode + "");
				Log.w("AsyncHttpResponse_onSuccess_Result", "AsyncHttpResponse_onSuccess_Result" + "\r\n" + result);
				/*if (headers != null) {
					for (Header header : headers) {
						Log.w("Header:", header.toString());
					}
				}*/
		} catch (UnsupportedEncodingException e) {
		} catch (Exception e) {
		}
	}

	/**
	 * 返回http string
	 *
	 * @param statusCode
	 * @param headers
	 * @param bytes
	 * @return
	 */
	public String onSuccessStr(int statusCode, Header[] headers, byte[] bytes) {
		String result = "";
		try {
			result = new String(bytes, CHARSET);
			if (statusCode < 200 || statusCode >= 400 || TextUtils.isEmpty(result)) {
				result = "";
			}
			Log.w("AsyncHttpResponse_onSuccessStr_StatusCode", statusCode + "");
			Log.w("AsyncHttpResponse_onSuccessStr_Result", "AsyncHttpResponse_onSuccessStr_Result" + "\r\n" + result);
		} catch (UnsupportedEncodingException e) {
				Log.w("AsyncHttpResponse_onSuccessStr_UnsupportedEncodingException", e.getMessage());
		} catch (Exception e) {
			Log.w("AsyncHttpResponse_onSuccessStr_Exception", e.getMessage());
		}
		return result;
	}

	/**
	 * 返回http log
	 *
	 * @param statusCode
	 * @param headers
	 * @param bytes
	 */
	public void onSuccessLog(int statusCode, Header[] headers, byte[] bytes) {
		String result = "";
		try {
			result = new String(bytes, CHARSET);
			Log.w("AsyncHttpResponse_onSuccessLog_StatusCode", statusCode + "");
			Log.w("AsyncHttpResponse_onSuccessLog_Result", "AsyncHttpResponse_onSuccessLog_Result" + "\r\n" + result);
		} catch (UnsupportedEncodingException e) {
			Log.w("AsyncHttpResponse_onSuccessLog_UnsupportedEncodingException", e.getMessage());
		} catch (Exception e) {
			Log.w("AsyncHttpResponse_onSuccessLog_Exception", e.getMessage());
		}
	}


	@Override
	public void onFailure(int statusCode, Header[] headers, byte[] bytes, Throwable throwable) {
		if (handler != null) {
			handler.obtainMessage(AsyncResponseErr, statusCode + "").sendToTarget();
		}
		Log.w("AsyncHttpResponse_onFailure_StatusCode", statusCode + "");
		Log.w("AsyncHttpResponse_onFailure_Throwable", "AsyncHttpResponse_onFailure_Throwable" + "\r\n" + throwable.getMessage());
	}

	/**
	 * onFailureLog
	 * @param statusCode
	 * @param headers
	 * @param bytes
	 * @param throwable
	 */
	public void onFailureLog(int statusCode, Header[] headers, byte[] bytes, Throwable throwable) {
		Log.w("AsyncHttpResponse_onFailure_StatusCode", statusCode + "");
		Log.w("AsyncHttpResponse_onFailure_Throwable", "AsyncHttpResponse_onFailure_Throwable" + "\r\n" + throwable.getMessage());
	}

	@Override
	public void onRetry(int retryNo) {
		super.onRetry(retryNo);
	}

	@Override
	public void onCancel() {
		super.onCancel();
	}

	@Override
	public void onUserException(Throwable error) {
		super.onUserException(error);
	}
}
