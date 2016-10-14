package com.hpe.book.pojo;

import java.awt.Event;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{
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
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println(this.username+"上线了");
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		@SuppressWarnings("unchecked")
		List<User> userlist = (List<User>) context.getAttribute("user_list");
		if (userlist==null) {
			userlist= new ArrayList<>();
		}
		userlist.add(this);
		context.setAttribute("user_list", userlist);
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println(this.username+"下线了");
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		@SuppressWarnings("unchecked")
		List<User> userlist = (List<User>) context.getAttribute("user_list");
		if (userlist==null) {
			userlist= new ArrayList<>();
		}
		userlist.add(this);
		context.setAttribute("user_list", userlist);		
	}
	

}
