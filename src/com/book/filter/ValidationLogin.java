package com.book.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class ValidationLogin
 */
public class ValidationLogin implements Filter {

    /**
     * Default constructor. 
     */
    public ValidationLogin() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
				// login.html for login form
		
				String user=request.getParameter("uname");
				System.out.println("validationFilter: "+user);
				if(user.equals(null)|| user.length()==0)
				{
					PrintWriter out=response.getWriter();
					out.println("<h3>Not Entered any data.</h3>");
					response.setContentType("text/html");
					RequestDispatcher rd=request.getRequestDispatcher("login.html");
					rd.include(request, response);
				}
				// pass the request along the filter chain
				else
				{
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
