package com.network.Interface;

/**
 * ��������Ļص���,����model��ʹ��
 * 
 * @author liyao
 * 
 */
public interface NetWorkListener {

	/**
	 * ����ɹ�,���ϴ�����Ӧ����
	 * 
	 * @param json
	 */
	public void netWorkSuccess(String json);

	/**
	 * ����ʧ��,���ϴ���״̬��
	 * 
	 * @param code
	 */
	public void netWorkError(String code);
}
