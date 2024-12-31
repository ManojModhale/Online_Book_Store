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
 * Servlet Filter implementation class PasswordFilter1
 */
public class PasswordFilter1 implements Filter {

    /**
     * Default constructor. 
     */
    public PasswordFilter1() {
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
		
				//newuser.html for registration form	
				String pass=request.getParameter("pass");
				String conf_pass=request.getParameter("confirmpass");
				
				if(pass.equals(conf_pass))
				{
					//	chain.doFilter(request, response);
					//	System.out.println("in if");
					RequestDispatcher rd=request.getRequestDispatcher("RegistrationServlet");
					rd.forward(request, response);
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter out=response.getWriter();
					out.println("<h3>Password Not Matched.</h3>");					
					System.out.println("in else");
					RequestDispatcher rd=request.getRequestDispatcher("newuser.html");
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
