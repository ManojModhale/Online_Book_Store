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

import com.book.bean.NewUser;
import com.book.dao.NewUserDAO;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		PrintWriter out=response.getWriter();
		String firstname=request.getParameter("fname");
		String lastname=request.getParameter("lname");
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		String email=request.getParameter("mail");
		String mobile_no=request.getParameter("mobileno");
		String gender=request.getParameter("gender");
		
		NewUser nuobj=new NewUser(firstname, lastname, username, password, email, mobile_no, gender);
		NewUserDAO nudao=new NewUserDAO();
		int row=nudao.insertData(con, nuobj);
		if(row==1)
		{
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h6>Something Went Wrong,Please try again.</h6>");
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("newuser.html");
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
