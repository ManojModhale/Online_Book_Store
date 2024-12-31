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
 * Servlet implementation class NewPasswordServlet
 */
public class NewPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPasswordServlet() {
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
		HttpSession hs=request.getSession(false);
		
		String username=(String) hs.getAttribute("username_forgot");
		System.out.println("newpassword : "+username);
		String password=request.getParameter("pass");
		
		
		NewUser nuobj=new NewUser(null,null,username, password,null,null,null);
		NewUserDAO nudao=new NewUserDAO();
		int row=nudao.updateData(con, nuobj);
		
		if(row==1)
		{
			System.out.println("newpassword1 html"+username);
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("newpassword2 html"+username);
			out.println("<h6>Something Went Wrong, Password not Updated.</h6>");
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("newpassword.html");
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
