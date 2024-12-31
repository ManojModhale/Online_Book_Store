package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.book.bean.NewUser;
import com.book.bean.Payment;

public class NewUserDAO 
{

	//registration
	public int insertData(Connection con,NewUser nuobj)
	{
		int rows=0;
		String insert="insert into newuser values (?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement pstat=con.prepareStatement(insert);
			pstat.setString(1, nuobj.getFirstname());
			pstat.setString(2, nuobj.getLastname());
			pstat.setString(3, nuobj.getUsername());
			pstat.setString(4, nuobj.getPassword());
			pstat.setString(5, nuobj.getEmail());
			pstat.setString(6, nuobj.getMobile_no());
			pstat.setString(7, nuobj.getGender());
			rows=pstat.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rows;	
	}
	
	//login
	public boolean selectData(Connection con,NewUser nuobj)
	{
		boolean ans=false;
		String select1="select * from newuser where username=?";
		try
		{
			PreparedStatement pstat=con.prepareStatement(select1);
			pstat.setString(1, nuobj.getUsername());
			ResultSet rs=pstat.executeQuery();
			rs.next();
			if(((nuobj.getUsername()).equals(rs.getString(3))) && ((nuobj.getPassword()).equals(rs.getString(4))))
			{
				ans=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ans;
	}
	
	//forgot password 
	public String selectOtp1(Connection con,NewUser nuobj)
	{
		String emailadd=null;
		String select2="select * from newuser where username=?";
		System.out.println(nuobj.getFirstname());
		try
		{	
			PreparedStatement pstat=con.prepareStatement(select2);
			pstat.setString(1, nuobj.getUsername());
			ResultSet rs=pstat.executeQuery();
			rs.next();
			if( ((nuobj.getUsername()).equals(rs.getString(3))))
			{
				emailadd=rs.getString(5);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return emailadd;	
	}
	public String selectOtp2(Connection con,NewUser nuobj)
	{
		String mobile=null;
		String select2="select * from newuser where username=?";
		System.out.println(nuobj.getFirstname());
		try
		{	
			PreparedStatement pstat=con.prepareStatement(select2);
			pstat.setString(1, nuobj.getUsername());
			ResultSet rs=pstat.executeQuery();
			rs.next();
			if( ((nuobj.getUsername()).equals(rs.getString(3))))
			{
				mobile=rs.getString(6);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return mobile;	
	}
	
	//new password
	public int updateData(Connection con,NewUser nuobj)
	{
		int rows=0;
		String update="update newuser set password=? where username=?";
		try
		{
			PreparedStatement pstat=con.prepareStatement(update);
			pstat.setString(1, nuobj.getPassword());
			pstat.setString(2, nuobj.getUsername());
			rows=pstat.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	//explore page 
	public String retriveName(Connection con,NewUser nuobj)
	{
		String name=null;
		String select3="select firstname from newuser where username=?";
		try
		{
			PreparedStatement pstat=con.prepareStatement(select3);
			pstat.setString(1, nuobj.getUsername());
			ResultSet rs=pstat.executeQuery();
			rs.next();
			if((nuobj.getUsername()).equals(rs.getString(3)))
			{
				name=rs.getString(3);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return name;
	}
	
	public String retrivecolumn(Connection con,String choose)
	{
		String s1=null;
		
		try
		{
			String query1="select * from newuser";
			Statement st=con.createStatement();
			boolean ans=st.execute(query1);
			if(ans)
			{
				ResultSet rs=st.getResultSet();
				ResultSetMetaData rsmd=rs.getMetaData();
				
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					if(choose.equalsIgnoreCase(rsmd.getColumnName(i)))
					{
						s1=rsmd.getColumnName(i);
					}
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return s1;
	}
	//payment jsp form
	public int insertPaymentDetails(Connection con,Payment p)
	{
		int rows=0;
		String insert="insert into userInfo values (?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement pstat=con.prepareStatement(insert);
			pstat.setString(1, p.getUsername());
			pstat.setString(2, p.getCardNumber());
			pstat.setString(3, p.getExpiryDate());
			pstat.setString(4, p.getCvv());
			pstat.setString(5, p.getAddress());
			pstat.setString(6, p.getCity());
			pstat.setString(7, p.getPinCode());
			rows=pstat.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rows;	
	}
	
	//cart.jsp receipt
	
	

}
