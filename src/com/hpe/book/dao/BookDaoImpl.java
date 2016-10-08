package com.hpe.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hpe.book.pojo.Book;

/**
 * @author keller
 * @date 创建时间：2016年10月8日下午3:58:03
 * @version 1.0
 */
public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public List<Book> getBookList() {
		List<Book> list = new ArrayList<>();
		String sql = "select *from book";
		ResultSet rs = null;
		rs= super.executeQuery(sql, null);
		try {
			while(rs.next()){
				Book book=new Book();
				book.setBookid(rs.getString("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBookprice(rs.getFloat("bookprice"));
				book.setBooktype(rs.getString("booktype"));
				book.setBookdate(rs.getDate("bookdate"));
				list.add(book);	
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
		return list;
	}

	@Override
	public Book getBookById(String bookid) {
		// TODO Auto-generated method stub
		Book book=null;
		String sql="select * from book where bookid=?";
		Object[] args=new Object[]{bookid}; 
		ResultSet rs=null;
		try {
			rs=super.executeQuery(sql, args);
			while(rs.next()){
			    book=new Book();
				book.setBookid(rs.getString("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBookprice(rs.getFloat("bookprice"));
				book.setBooktype(rs.getString("booktype"));
				book.setBookdate(rs.getDate("bookdate"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				super.colseAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return book;
	}

	@Override
	public List<Book> getBookByAuthor(String bookauthor) {
		List<Book> list=new ArrayList<Book>();
		String sql="select * from book where bookauthor=?";
		Object[] args=new Object[]{bookauthor}; 
		ResultSet rs=null;
		try {
			rs=super.executeQuery(sql, args);
			while(rs.next()){
				Book book=new Book();
				book.setBookid(rs.getString("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBookprice(rs.getFloat("bookprice"));
				book.setBooktype(rs.getString("booktype"));
				book.setBookdate(rs.getDate("bookdate"));
				list.add(book);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				super.colseAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Book getBookByName(String bookname) {
		Book book=null;
		String sql="select * from book where bookname=?";
		Object[] args=new Object[]{bookname}; 
		ResultSet rs=null;
		try {
			rs=super.executeQuery(sql, args);
			while(rs.next()){
			    book=new Book();
				book.setBookid(rs.getString("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBookprice(rs.getFloat("bookprice"));
				book.setBooktype(rs.getString("booktype"));
				book.setBookdate(rs.getDate("bookdate"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				super.colseAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return book;
	}

	@Override
	public int deleteById(String bookid) {
		int num=-1;
		String sql="delete from book where bookid=?";
		Object[] args=new Object[]{bookid}; 
	    try {
			num=super.executeUpdate(sql, args);
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
		return num;
	}

	@Override
	public int update(Book book) {
		int num=-1;
		String sql="update book set bookname=?,bookauthor=?,booktype=?,bookprice=?,bookdate=? where bookid=?";
		Object[] args=new Object[]{book.getBookname(),book.getBookauthor(),book.getBooktype(),book.getBookprice(),new java.sql.Date(book.getBookdate().getTime()),book.getBookid()}; 
	    try {
			num=super.executeUpdate(sql, args);
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
		return num;
	}

	@Override
	public int addBook(Book book) {
		int num=-1;
		String sql="insert into book (bookid,bookname,bookauthor,booktype,bookprice,bookdate) values(?,?,?,?,?,?)";
		Object[] args=new Object[]{book.getBookid(),book.getBookname(),book.getBookauthor(),book.getBooktype(),book.getBookprice(),new java.sql.Date(book.getBookdate().getTime())}; 
	    try {
			num=super.executeUpdate(sql, args);
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
		return num;
	}

}
