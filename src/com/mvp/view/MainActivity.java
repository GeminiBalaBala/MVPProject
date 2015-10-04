package com.mvp.view;

import com.activity.BaseActivity;
import com.example.edaiximvp.R;
import com.mvp.presenter.UserPresenter;

import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

	private UserPresenter userPresenter;
	private EditText username;
	private EditText password;
	private Button login;
	private TextView uid;
	private TextView sessionid;
	private TextView name;
	private TextView user_token;
	private TextView user_type;
	private TextView unique_number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		initData();
	}

	@Override
	public void initView() {
		super.initView();
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);
		uid = (TextView) findViewById(R.id.uid);
		sessionid = (TextView) findViewById(R.id.sessionid);
		name = (TextView) findViewById(R.id.name);
		user_token = (TextView) findViewById(R.id.user_token);
		user_type = (TextView) findViewById(R.id.user_type);
		unique_number = (TextView) findViewById(R.id.unique_number);
	}

	@Override
	public void initData() {
		super.initData();
		login.setOnClickListener(MainActivity.this);
		userPresenter = new UserPresenter(MainActivity.this);
	}

	@Override
	public void refreshView() {
		super.refreshView();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login:
			if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
				Toast.makeText(MainActivity.this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
			}else{
				userPresenter.loadUser(username.getText().toString(),password.getText().toString());				
			}
			break;

		default:
			break;
		}
	}
	
	public void setUid(String uid){
		this.uid.setText(uid);
	}
	
	public void setSessionid(String sessionid){
		this.sessionid.setText(sessionid);
	}
	
	public void setName(String name){
		this.name.setText(name);
	}
	
	public void setUser_token(String user_token){
		this.user_token.setText(user_token);
	}
	
	public void setUser_type(String user_type){
		this.user_type.setText(user_type);
	}
	
	public void setUnique_number(String unique_number){
		this.unique_number.setText(unique_number);
	}
	
}
