package com.activity;

/**
 * Created by liyao. activity�Ľӿ� onCreate�е���initView,initData
 */
public interface IActivity {

	/**
	 * ��ʼ������,findviewbyId
	 */
	public void initView();

	/**
	 * ��������
	 */
	public void initData();

	/**
	 * ˢ�½���,��������
	 */
	public void refreshView();
}
