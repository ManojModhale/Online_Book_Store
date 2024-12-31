package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.bean.Book;

public class BookDao 
{
	public int selectPrice(Connection con,Book b)
	{
		int price=0;
		String price1="select * from book where bookId=?";
		try
		{
			PreparedStatement pstat=con.prepareStatement(price1);
			pstat.setString(1, b.getBookId());
			ResultSet rs=pstat.executeQuery();
			rs.next();
			if( ((b.getBookId()).equals(rs.getString(1))))
			{
				price=rs.getInt(2);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return price;
	}

}
