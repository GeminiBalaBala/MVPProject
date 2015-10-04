package com.bean;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NoAutoIncrement;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "user")
public class User {
	
	@Id(column = "uid")
	@NoAutoIncrement
	private String uid;
	
	@Column(column = "sessionid")
	private String sessionid;
	
	@Column(column = "name")
	private String name;
	
	@Column(column = "user_token")
	private String user_token;
	
	@Column(column = "user_type")
	private String user_type;
	
	@Column(column = "unique_number")
	private String unique_number;
	
	public User() {
		super();
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_token() {
		return user_token;
	}
	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUnique_number() {
		return unique_number;
	}
	public void setUnique_number(String unique_number) {
		this.unique_number = unique_number;
	}
	
}
