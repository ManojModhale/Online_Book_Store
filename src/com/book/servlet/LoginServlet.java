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
 * Servlet implementation class LoginServlet
 */
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
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		System.out.println("loginservlet: "+username);
		NewUser nuobj=new NewUser(username, password);
		NewUserDAO nudao=new NewUserDAO();
		boolean ans=nudao.selectData(con, nuobj);
		if(ans==true)
		{
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("ExploreServlet");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h3>Please Enter Valid Login Credintials.</h3>");
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
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
