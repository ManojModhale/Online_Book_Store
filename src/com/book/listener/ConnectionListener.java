package com.book.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ConnectionListener
 *
 */
@WebListener
public class ConnectionListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ConnectionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    Connection con;
    ServletContext ctx; 
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ctx=arg0.getServletContext();
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		String url="jdbc:mysql://localhost:3306/bookstore";
    		con=DriverManager.getConnection(url, "root", "Developer@01");
    		
    		 Thread cleanupThread = new Thread(() -> {
    	            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
    	        });
    	        cleanupThread.start();
    		
    		ctx.setAttribute("DB_Con", con);
    	}
    	catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	
}
