package com.hpe.book.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.book.pojo.Book;
import com.hpe.book.service.BookService;
import com.hpe.book.service.BookServiceImpl;



/**
 * Servlet implementation class BookSevlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String reqType = request.getParameter("reqtype");
		if (reqType==null) {
			reqType = "query";
		}
		switch (reqType) {
		case "query":
            this.query(request, response);
			break;

		case "queryById":
			this.queryById(request, response);

			break;
		case "queryByName":
			this.queryByName(request, response);

			break;
		case "queryByAuthor":

			break;
		case "add":
			this.add(request, response);

			break;
		case "updateById":
            this.updateById(request, response);
			break;
		case "update":
            this.update(request, response);
			break;
		case "delete":
			this.delete(request, response);

			break;

		default:
			break;
		}

	}
	/**
	 * 查询图书的所有信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void query(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	    BookService bookService=new BookServiceImpl();
	    List<Book> list=bookService.getBookList();
	    request.setAttribute("book_list",list);
	    request.getRequestDispatcher("book_list.jsp").forward(request, response);
	
	}
	/**
	 * 通过Id查询图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void queryById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	
	
	/**
	 *  通过书名查询图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void queryByName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	/**
	 *  通过作者查询图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void queryByAuthor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	/**
	 *  添加图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookid=request.getParameter("bookid");
		String bookname=request.getParameter("bookname");
		String bookauthor=request.getParameter("bookauthor");
		String booktype=request.getParameter("booktype");
		String bookprice=request.getParameter("bookprice");
		String bookdate=request.getParameter("bookdate");
		
		Book book=new Book();
		book.setBookid(bookid);
		book.setBookname(bookname);
		book.setBookauthor(bookauthor);
		book.setBooktype(booktype);
		book.setBookprice(Float.parseFloat(bookprice));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dt=null;
		try {
			dt=sdf.parse(bookdate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.setBookdate(dt);
		BookService bookService=new BookServiceImpl();
		int num=bookService.addBook(book);
		this.query(request, response);
	}
	
	/**
	 *  修改图书信息之前先找出该条记录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookid=request.getParameter("bookid");
		BookService bookService=new BookServiceImpl();
		Book book=bookService.getBookById(bookid);
		request.setAttribute("book", book);
		request.getRequestDispatcher("book_update.jsp").forward(request, response);
			
	
	}
	/**
	 *  修改图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookid=request.getParameter("bookid");
		String bookname=request.getParameter("bookname");
		String bookauthor=request.getParameter("bookauthor");
		String booktype=request.getParameter("booktype");
		String bookprice=request.getParameter("bookprice");
		String bookdate=request.getParameter("bookdate");
		
		Book book=new Book();
		book.setBookid(bookid);
		book.setBookname(bookname);
		book.setBookauthor(bookauthor);
		book.setBooktype(booktype);
		book.setBookprice(Float.parseFloat(bookprice));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dt=null;
		try {
			dt=sdf.parse(bookdate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.setBookdate(dt);
		BookService bookService=new BookServiceImpl();
		int num=bookService.update(book);
		this.query(request, response);
	
	}
	/**
	 *  删除图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookid=request.getParameter("bookid");
		BookService bookService=new BookServiceImpl();
		int num=bookService.delete(bookid);
		this.query(request, response);
	
	}
	
	
	

}
