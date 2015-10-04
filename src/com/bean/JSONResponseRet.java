package com.bean;

public class JSONResponseRet {
	/**
	 * 40001异地登陆
	 */
	public static final int Error_40001 = 40001;

	/**
	 * 40051账号被禁用
	 */
	public static final int Error_40051 = 40051;

	/**
	 * result,为true时存在data
	 */
	private boolean ret = false;

	/**
	 * 错误信息
	 */
	private String error = "服务器异常";

	/**
	 * 错误码
	 */
	private int error_code = 0;

	private String ts;

	private boolean update = true;

	private String checksum = "";

	private int ttl = 0;

	public boolean getRet() {
		return ret;
	}

	public void setRet(boolean ret) {
		this.ret = ret;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public boolean setUpdate() {
		return update;
	}

	public void getUpdate(boolean update) {
		this.update = update;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}
}
