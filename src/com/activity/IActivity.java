package com.activity;

/**
 * Created by liyao. activity的接口 onCreate中调用initView,initData
 */
public interface IActivity {

	/**
	 * 初始化界面,findviewbyId
	 */
	public void initView();

	/**
	 * 构造数据
	 */
	public void initData();

	/**
	 * 刷新界面,重载数据
	 */
	public void refreshView();
}
