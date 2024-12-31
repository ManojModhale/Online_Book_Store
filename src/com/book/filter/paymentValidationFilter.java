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
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class paymentValidationFilter
 */
public class paymentValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public paymentValidationFilter() {
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
		//payment.jsp filter
 
		String cardNumber=request.getParameter("cardNumber");
		String expiryDate=request.getParameter("expiryDate");
		String cvv=request.getParameter("cvv");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String pinCode=request.getParameter("pinCode");
		
		if(cardNumber.length()==0||expiryDate.length()==0||cvv.length()==0||
				address.length()==0||city.length()==0||pinCode.length()==0)
		{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			out.println("<h3>Not Entered any data.</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");
			rd.include(request, response);
		}
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
