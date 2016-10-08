package com.hpe.book.pojo;

import java.util.Date;

public class Book {
	private String bookid;
	private String bookname;
	private String bookauthor;
	private String booktype;
	private float bookprice;
	private Date bookdate;
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public float getBookprice() {
		return bookprice;
	}
	public void setBookprice(float bookprice) {
		this.bookprice = bookprice;
	}
	public Date getBookdate() {
		return bookdate;
	}
	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str=bookid+"\t"+bookname+"\t"+bookauthor+"\t"+booktype+"\t"+bookprice+"\t"+bookdate;
		return str;
	}

}
