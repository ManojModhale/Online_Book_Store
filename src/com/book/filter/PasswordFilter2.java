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
 * Servlet Filter implementation class PasswordFilter2
 */
public class PasswordFilter2 implements Filter {

    /**
     * Default constructor. 
     */
    public PasswordFilter2() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		// TODO Auto-generated method stub
		// place your code here

			//newpassword.html for new password form

				String pass=request.getParameter("pass");
				String conf_pass=request.getParameter("confirmpass");
				
				if(pass.equals(conf_pass))
				{
					chain.doFilter(request, response);
				}
				else
				{
					PrintWriter out=response.getWriter();
					out.println("<h3>Password Not Matched.</h3>");
					response.setContentType("text/html");
					RequestDispatcher rd=request.getRequestDispatcher("newpassword.html");
					rd.include(request, response);
				}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
