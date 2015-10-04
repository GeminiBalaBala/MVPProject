package com.mvp.model;

/**
 * model层加载数据的回调类,仅供presenter层使用
 * 
 * @author liyao
 * 
 */
public interface ModelCallback {

	/**
	 * 加载成功,业务bean获取成功,将bean向上传递
	 * 
	 * @param object
	 */
	public void loadSuccess(Object object);

	/**
	 * 加载成功,业务bean获取失败,将JSONResponseRet向上传递,JSONResponseRet中含有errormessage
	 * 
	 * @param object
	 */
	public void loadFailed(Object object);

	/**
	 * 加载失败,向上传递状态码
	 * 
	 * @param object
	 */
	public void loadError(Object object);

}
