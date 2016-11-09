package com.hpe.book.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.hpe.book.pojo.User;

import sun.misc.URLClassPath;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter(filterName = "LoginFilter", urlPatterns = { "/*" }, initParams = {
//		@WebInitParam(name = "path", value = "loginServlet") })
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获得用户请求的URI
		String path = req.getRequestURI();
		HttpSession session = req.getSession();
//		System.out.println("getServletPath:"+req.getServletPath());
//		System.out.println("req.getRequestURI:"+req.getRequestURI());
		// 登陆页面无需过滤
		if (path.indexOf("/login.jsp") > -1|| path.endsWith("LoginServlet")) {
			chain.doFilter(req, resp);
			return;
		}
		User user = (User) session.getAttribute("user");
		// 判断如果没有取到信息,就跳转到登陆页面
		if (user == null || "".equals(user)) {
			// 跳转到登陆页面
			resp.getWriter().print("<script>alert('未登录'); </script>");;
			resp.sendRedirect("login.jsp");
		} else {
			// 已经登陆,继续此次请求
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
