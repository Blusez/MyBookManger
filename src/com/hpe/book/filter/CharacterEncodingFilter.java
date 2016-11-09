package com.hpe.book.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter(description = "解决post、get方式出现中文乱码问题", urlPatterns = { "/CharacterEncodingFilter" })
public class CharacterEncodingFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CharacterEncodingFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// post方式提交的中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获取reques象的代理对象
		ServletRequest requestProxy = getHttpServletRequestProxy(request);

		// pass the request along the filter chain
		chain.doFilter(requestProxy, response);
	}

	private ServletRequest getHttpServletRequestProxy(final HttpServletRequest request) {
		// TODO Auto-generated method stub

		ServletRequest proxy =(ServletRequest) Proxy.newProxyInstance(CharacterEncodingFilter.class.getClassLoader(), request.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						//如果调用的方法是get且使用geParameter()方法
						if (request.getMethod().equalsIgnoreCase("get")&&method.getName().equals("getParameter")) {
							//调用getParameter方法获取参数
							String value = (String) method.invoke(request, args);
							if (value==null) {
								return null;
							}
							//解决get方法提交的乱码问题
							return new String (value.getBytes("iso8859-1"),"utf-8");
						}else {
							return method.invoke(request, args);
						}
					}
				});
		return proxy;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
