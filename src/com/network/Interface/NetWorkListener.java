package com.network.Interface;

/**
 * 网络操作的回调类,仅供model层使用
 * 
 * @author liyao
 * 
 */
public interface NetWorkListener {

	/**
	 * 网络成功,向上传递响应内容
	 * 
	 * @param json
	 */
	public void netWorkSuccess(String json);

	/**
	 * 网络失败,向上传递状态码
	 * 
	 * @param code
	 */
	public void netWorkError(String code);
}
