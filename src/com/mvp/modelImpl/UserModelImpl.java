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
 * model主要处理网络和数据库
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
		//pushtoken为消息推送的token,此处随便写了
		Map<String, String> params = AsyncParamsPackage.getInstance().loginPackage(AsyncRequestParams.getInstance().getLogin(username, pwd, "123456"));
		NetWork.getInstance().getNetWorkJson(url,params,netWorkListener);
	}
	
	/**
	 * 网络成功的回调类
	 * 然后将响应结果解析,再次回调给presenter
	 * mvp任何层级当中最好不要有第三方框架的代码(除非非常稳定的代码,长期不会更换,如Gson)
	 * 保持各个层级的纯净,禁止杂糅,将第三方框架完全抽离,防止更换第三方api时替换太多
	 * json处理得草率,应该抽调出来供全局使用
	 * 此处的数据库处理仅仅是insert而已
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
