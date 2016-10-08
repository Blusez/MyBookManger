package com.hpe.book.pojo;
public class User {
	private String userid;
	private String username;
	private String userpwd;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str=userid+"\t"+username+"\t"+userpwd;
		return str;
	}
	

}
