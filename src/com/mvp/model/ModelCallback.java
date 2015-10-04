package com.mvp.model;

/**
 * model��������ݵĻص���,����presenter��ʹ��
 * 
 * @author liyao
 * 
 */
public interface ModelCallback {

	/**
	 * ���سɹ�,ҵ��bean��ȡ�ɹ�,��bean���ϴ���
	 * 
	 * @param object
	 */
	public void loadSuccess(Object object);

	/**
	 * ���سɹ�,ҵ��bean��ȡʧ��,��JSONResponseRet���ϴ���,JSONResponseRet�к���errormessage
	 * 
	 * @param object
	 */
	public void loadFailed(Object object);

	/**
	 * ����ʧ��,���ϴ���״̬��
	 * 
	 * @param object
	 */
	public void loadError(Object object);

}
