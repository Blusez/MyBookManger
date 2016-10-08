package com.hpe.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hpe.book.pojo.User;

/**
 * @author keller
 * @date 创建时间：2016年10月8日下午4:06:13
 * @version 1.0
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String sql="select * from users where username=? and userpwd=?";
		Object[] args=new Object[]{user.getUsername(),user.getUserpwd()};
		User rtnUser=null;
		ResultSet rs;
		try {
			rs = super.executeQuery(sql, args);
			while(rs.next()){
				rtnUser=new User();
				rtnUser.setUserid(rs.getString("userid"));
				rtnUser.setUsername(rs.getString("username"));
				rtnUser.setUserpwd(rs.getString("userpwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				super.colseAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rtnUser;
	}

}
