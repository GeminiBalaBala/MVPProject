package com.mvp.presenter;


import android.widget.Toast;

import com.bean.JSONResponseRet;
import com.bean.User;
import com.mvp.model.ModelCallback;
import com.mvp.modelImpl.UserModelImpl;
import com.mvp.view.MainActivity;

/**
 * model和view的链接,处理主要逻辑
 * 
 * @author liyao
 * 
 */
public class UserPresenter {

	private MainActivity userView;
	private UserModelImpl userModelImpl;
	
	/**
	 * 在此声明model的回调,因为model可能有网络操作,并不在主线程内
	 * 此处也可以发送handler.post来更新UI
	 */
	private ModelCallback modelCallback = new ModelCallback() {
		
		@Override
		public void loadSuccess(Object object) {
			// TODO Auto-generated method stub
			User user = (User) object;
			userView.setUid(user.getUid());
			userView.setSessionid(user.getSessionid());
			userView.setName(user.getName());
			userView.setUser_token(user.getUser_token());
			userView.setUser_type(user.getUser_type());
			userView.setUnique_number(user.getUnique_number());
		}
		
		@Override
		public void loadFailed(Object object) {
			// TODO Auto-generated method stub
			JSONResponseRet jsonResponseRet = (JSONResponseRet) object;
			Toast.makeText(userView, jsonResponseRet.getError(), Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public void loadError(Object object) {
			// TODO Auto-generated method stub
			Toast.makeText(userView, "网络异常", Toast.LENGTH_SHORT).show();
		}
	};
	

	public UserPresenter(MainActivity userView) {
		super();
		this.userView = userView;
		this.userModelImpl = new UserModelImpl(modelCallback);
	}

	/**
	 * 请求user对象,此处不应该将userView向下传递
	 */
	public void loadUser(String username,String pwd) {
		userModelImpl.loadUser(username, pwd);
	}

}
