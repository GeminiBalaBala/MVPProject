package com.mvp.modelImpl;

import java.util.Map;
import android.util.Log;

import com.bean.JSONResponseRet;
import com.bean.User;
import com.database.UserDataBaseHelper;
import com.google.gson.Gson;
import com.mvp.model.ModelCallback;
import com.network.AsyncParamsPackage;
import com.network.AsyncRequestParams;
import com.network.NetWork;
import com.network.Interface.NetWorkListener;


import org.json.JSONObject;

/**
 * model��Ҫ������������ݿ�
 * @author liyao
 *
 */
public class UserModelImpl {
	
	private final String TAG = "UserModelImpl";
	private ModelCallback modelCallback;
	
	public UserModelImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public UserModelImpl(ModelCallback modelCallback) {
		super();
		this.modelCallback = modelCallback;
	}

	public void setModelUser(User user) {
		// TODO Auto-generated method stub
	}
	
	public void loadUser(String username,String pwd){
		String url = "http://abc/login";
		//pushtokenΪ��Ϣ���͵�token,�˴����д��
		Map<String, String> params = AsyncParamsPackage.getInstance().loginPackage(AsyncRequestParams.getInstance().getLogin(username, pwd, "123456"));
		NetWork.getInstance().getNetWorkJson(url,params,netWorkListener);
	}
	
	/**
	 * ����ɹ��Ļص���
	 * Ȼ����Ӧ�������,�ٴλص���presenter
	 * mvp�κβ㼶������ò�Ҫ�е�������ܵĴ���(���Ƿǳ��ȶ��Ĵ���,���ڲ������,��Gson)
	 * ���ָ����㼶�Ĵ���,��ֹ����,�������������ȫ����,��ֹ����������apiʱ�滻̫��
	 * json����ò���,Ӧ�ó��������ȫ��ʹ��
	 * �˴������ݿ⴦�������insert����
	 */
	private NetWorkListener netWorkListener = new NetWorkListener() {
		
		@Override
		public void netWorkSuccess(String httpResponse) {
			Gson gson = new Gson();
			JSONResponseRet jsonResponseRet = new JSONResponseRet();
			try {
				jsonResponseRet = gson.fromJson(httpResponse, JSONResponseRet.class);
				if(jsonResponseRet.getRet()){
					JSONObject jsonObject = new JSONObject(httpResponse);
					String userJson = jsonObject.optJSONObject("data").toString();
					User user = gson.fromJson(userJson, User.class);
					UserDataBaseHelper.getInstance().putUserNotifiUI(user);
					modelCallback.loadSuccess(user);
				}else{
					modelCallback.loadFailed(jsonResponseRet);
				}
			} catch (Exception e) {
				Log.w(TAG, e.getMessage());
			}
		}
		
		@Override
		public void netWorkError(String code) {
			modelCallback.loadError(code);
		}
	};
	
	
}
