package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.bean.Payment;
import com.book.dao.NewUserDAO;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con;
    ServletContext ctx;
	public void init(ServletConfig config) throws ServletException 
	{
		// TODO Auto-generated method stub
		ctx=config.getServletContext();
		con=(Connection) ctx.getAttribute("DB_Con");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession hs=request.getSession(false);
		PrintWriter out=response.getWriter();
		
		String username=(String)hs.getAttribute("username"); 
		String cardNumber=request.getParameter("cardNumber");
		String expiryDate=request.getParameter("expiryDate");
		String cvv=request.getParameter("cvv");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String pinCode=request.getParameter("pinCode");

		Payment p=new Payment(username, cardNumber, expiryDate, cvv, address, city, pinCode);
		
		NewUserDAO ndao=new NewUserDAO();
		int rows=ndao.insertPaymentDetails(con, p);
		if(rows==1)
		{
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h6>Something Went Wrong,Please try again.</h6>");
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");
			rd.include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
