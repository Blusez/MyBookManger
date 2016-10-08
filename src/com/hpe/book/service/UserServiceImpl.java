package com.hpe.book.service;

import com.hpe.book.dao.UserDao;
import com.hpe.book.dao.UserDaoImpl;
import com.hpe.book.pojo.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao=new UserDaoImpl();
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
