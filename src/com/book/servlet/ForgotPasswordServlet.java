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

import com.book.bean.NewUser;
import com.book.dao.NewUserDAO;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
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
		HttpSession hs=request.getSession();
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("uname");
		System.out.println("--"+username);
		hs.setAttribute("username_forgot", username);
		String choose=request.getParameter("chooseOtp");
		NewUser nuobj=new NewUser(null,null,username,null,null,null,null);
		NewUserDAO nudao=new NewUserDAO();
		
		if(choose.equals("email"))
		{
			String emailadd=nudao.selectOtp1(con, nuobj);
			if(emailadd.equals(null))
			{
				response.setContentType("text/html");
				out.println("null email Address");
				RequestDispatcher rd=request.getRequestDispatcher("forgotpass.html");
				rd.include(request, response);
			}
			else
			{
				response.setContentType("text/html");
				System.out.println("forgot html"+username);
				out.println("<br/><br/><br/><pre>&emsp;&emsp;&emsp;&emsp;&emsp;<h5>Email address : "+emailadd+"</h5></pre>");
				RequestDispatcher rd=request.getRequestDispatcher("newpassword.html");
				rd.include(request, response);
				
			}
		}
		else
		{
			String mobile=nudao.selectOtp2(con, nuobj);
			if(mobile.equals(null))
			{
				response.setContentType("text/html");
				out.println("null Mobile Number");
				RequestDispatcher rd=request.getRequestDispatcher("forgotpass.html");
				rd.include(request, response);
			}
			else
			{
				response.setContentType("text/html");				
				System.out.println(username);
				out.println("<br/><br/><br/>&emsp;&emsp;&emsp;&emsp;&emsp;<h5>Mobile Number : "+mobile+"</h5>");
				RequestDispatcher rd=request.getRequestDispatcher("newpassword.html");
				rd.include(request, response);
				
			}
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
