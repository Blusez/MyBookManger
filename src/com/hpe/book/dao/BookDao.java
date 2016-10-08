package com.hpe.book.dao;

import java.util.List;

import com.hpe.book.pojo.Book;

/**
 * @author keller
 * @date 创建时间：2016年10月8日下午3:24:19
 * @version 1.0
 */
public interface BookDao {
	List<Book> getBookList();//获取所有图书信息
	//通过id获取图书信息
	Book getBookById(String bookid);
	//通过作者获取图书信息
	List<Book> getBookByAuthor(String bookauthor);
	//通过书名来获取图书信息
	Book getBookByName(String bookname);
	//通过bookid删除图书
	int deleteById(String bookid);
	//修改图书信息
	int update(Book book);
	//添加图书
	int addBook(Book book);
	
}
