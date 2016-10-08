package com.hpe.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.book.pojo.User;
import com.hpe.book.service.UserService;
import com.hpe.book.service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqtype=request.getParameter("reqtype");
		if(reqtype.equals("logout")){
			HttpSession session=request.getSession();
			session.removeAttribute("user");
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User ur = new User();
		ur.setUsername(name);
		ur.setUserpwd(pwd);
		UserService userService = new UserServiceImpl();
		User user = userService.login(ur);
		if (user != null) {

			String[] autoLogin = request.getParameterValues("autoLogin");
			if (autoLogin != null) {
				Cookie ck1 = new Cookie("name", name);
				Cookie ck2 = new Cookie("pwd", pwd);
				ck1.setMaxAge(60 * 60 * 24 * 5);
				ck1.setMaxAge(60 * 60 * 24 * 5);
				response.addCookie(ck1);
				response.addCookie(ck2);

			} else {
				Cookie ck1 = new Cookie("name", "");
				Cookie ck2 = new Cookie("pwd", "");
				ck1.setMaxAge(0);
				ck1.setMaxAge(0);
				response.addCookie(ck1);
				response.addCookie(ck2);

			}

			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			System.out.println("main.jsp");
			response.sendRedirect("main.jsp");

		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
