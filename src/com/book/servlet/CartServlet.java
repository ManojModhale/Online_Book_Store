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

import com.book.bean.Book;
import com.book.dao.BookDao;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		//String username=request.getParameter("uname");
		PrintWriter out=response.getWriter();
		String bookId=null;
		if(request.getParameter("m1")!=null)
		{
			bookId=request.getParameter("m1");
		}
		else if(request.getParameter("m2")!=null)
		{
			bookId=request.getParameter("m2");
		}
		else if(request.getParameter("m3")!=null)
		{
			bookId=request.getParameter("m3");
		}
		else if(request.getParameter("m4")!=null)
		{
			bookId=request.getParameter("m4");
		}
		else if(request.getParameter("m5")!=null)
		{
			bookId=request.getParameter("m5");
		}
		else if(request.getParameter("m6")!=null)
		{
			bookId=request.getParameter("m6");
		}
		else if(request.getParameter("h1")!=null)
		{
			bookId=request.getParameter("h1");
		}
		else if(request.getParameter("h2")!=null)
		{
			bookId=request.getParameter("h2");
		}
		else if(request.getParameter("h3")!=null)
		{
			bookId=request.getParameter("h3");
		}
		else if(request.getParameter("h4")!=null)
		{
			bookId=request.getParameter("h4");
		}
		else if(request.getParameter("h5")!=null)
		{
			bookId=request.getParameter("h5");
		}
		else if(request.getParameter("h6")!=null)
		{
			bookId=request.getParameter("h6");
		}
		else if(request.getParameter("e1")!=null)
		{
			bookId=request.getParameter("e1");
		}
		else if(request.getParameter("e2")!=null)
		{
			bookId=request.getParameter("e2");
		}
		else if(request.getParameter("e3")!=null)
		{
			bookId=request.getParameter("e3");
		}
		else if(request.getParameter("e4")!=null)
		{
			bookId=request.getParameter("e4");
		}
		else if(request.getParameter("e5")!=null)
		{
			bookId=request.getParameter("e5");
		}
		else
		{
			bookId=request.getParameter("e6");
		}
		
		
		Book b=new Book();
		b.setBookId(bookId);
		
		BookDao bDao=new BookDao();
		int price=bDao.selectPrice(con, b);
		
		HttpSession hs=request.getSession(false);
		hs.setAttribute(bookId, price);
		
		response.setContentType("text/html");
	    out.println("<html><head><title>Alert Box Example</title></head><body>");
	    out.println("<script type=\"text/javascript\">");
	    out.println("alert('Book Added Successfully.');");
	    out.println("</script>");
	    out.println("</body></html>");
		RequestDispatcher rd=request.getRequestDispatcher("explore.html");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
