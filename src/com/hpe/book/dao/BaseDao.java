package com.hpe.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author keller
 * @date 创建时间：2016年10月8日下午3:33:19
 * @version 1.0
 */
public class BaseDao {
	private static final String DRIVERCLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin://localhost:1521/orcl";
	private static final String USERNAME = "keller";
	private static final String PASSWORD = "123456";
	
	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	
	static{
		try{
			Class.forName(DRIVERCLASS);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 执行查询语句
	 * @param sql
	 * @param args
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object[] args){
		conn = this.getConnection();
		try {
			pst =conn.prepareStatement(sql);
			if (args !=null) {
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i+1, args[i]);
				}
			}
			rs= pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 执行更新语句
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public int executeUpdate(String sql, Object[] args) throws SQLException{
		int num=-1;
		conn=this.getConnection();
		pst = conn.prepareStatement(sql);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i + 1, args[i]);
			}
		}
		num=pst.executeUpdate();
		return num;
	}
	/**
	 * 关闭连接
	 * @throws SQLException
	 */
	public void colseAll() throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(pst!=null){
			pst.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	

}
