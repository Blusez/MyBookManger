package com.hpe.book.service;

import java.util.List;

import com.hpe.book.dao.BookDao;
import com.hpe.book.dao.BookDaoImpl;
import com.hpe.book.pojo.Book;



public class BookServiceImpl implements BookService {

	private BookDao bookDao=new BookDaoImpl();
	
	@Override
	public List<Book> getBookList() {
		// TODO Auto-generated method stub
		return bookDao.getBookList();
	}

	@Override
	public Book getBookById(String bookid) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(bookid);
	}

	@Override
	public List<Book> getBookByAuthor(String bookauthor) {
		// TODO Auto-generated method stub
		return bookDao.getBookByAuthor(bookauthor);
	}

	@Override
	public Book getBookByName(String bookname) {
		// TODO Auto-generated method stub
		return bookDao.getBookByName(bookname);
	}

	@Override
	public int delete(String bookid) {
		// TODO Auto-generated method stub
		return bookDao.deleteById(bookid);
	}

	@Override
	public int update(Book book) {
		// TODO Auto-generated method stub
		return bookDao.update(book);
	}

	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}

}
