package com.bean;

public class JSONResponseRet {
	/**
	 * 40001��ص�½
	 */
	public static final int Error_40001 = 40001;

	/**
	 * 40051�˺ű�����
	 */
	public static final int Error_40051 = 40051;

	/**
	 * result,Ϊtrueʱ����data
	 */
	private boolean ret = false;

	/**
	 * ������Ϣ
	 */
	private String error = "�������쳣";

	/**
	 * ������
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
