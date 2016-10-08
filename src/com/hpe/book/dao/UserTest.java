package com.hpe.book.dao;

import org.junit.Test;

import com.hpe.book.pojo.User;

/**
 * Junit测试数据库是否可以连接
 * @author keller
 * @date 创建时间：2016年10月8日下午4:08:03
 * @version 1.0
 */
public class UserTest {
	private UserDao userDao=new UserDaoImpl();
	@Test
	public void testname() throws Exception {
		User ur=new User();
		ur.setUsername("sa");
		ur.setUserpwd("123");
		User user=userDao.login(ur);
		System.out.println(user);
	}

}
