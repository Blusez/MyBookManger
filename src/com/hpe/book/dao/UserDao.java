package com.hpe.book.dao;

import com.hpe.book.pojo.User;

/**
 * @author keller
 * @date 创建时间：2016年10月8日下午4:05:12
 * @version 1.0
 */
public interface UserDao {
	User login(User user);//用户登录
	
}
