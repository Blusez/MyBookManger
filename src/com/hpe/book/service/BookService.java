package com.hpe.book.service;

import java.util.List;

import com.hpe.book.pojo.Book;

public interface BookService {
	List<Book> getBookList();// 获取所有图书信息

	Book getBookById(String bookid);// 通过id获取图书信息

	List<Book> getBookByAuthor(String bookauthor);// 通过作者获取图书信息

	Book getBookByName(String bookname);// 通过书名获取图书信息

	int delete(String bookid);// 通过bookid删除图书信息

	int update(Book book);// 修改图书信息

	int addBook(Book book);// 添加图书
	// 1.获取图书记录总数
	int getTotalCount();
	// 2.获取当前页的图书信息
	List<Book> getBookList(int currentStart, int currentEnd);
}
