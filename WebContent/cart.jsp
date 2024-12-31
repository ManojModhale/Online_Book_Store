<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.book.bean.Book" %>
    <%@ page import="com.book.bean.NewUser" %>
    <%@ page import="com.book.dao.NewUserDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: white;
        }
        .outerdiv
        {
        	background-color: #f0f0f0;
        	position: relative;
        	left: 550px;
        	border : 4px solid red;
        	border-radius: 10px;
        	height: 200px;
        	width:300px;
        	padding: 20px;
        }
        .div1 {
        	
            //background-color: #007bff;
            color: #007bff;
            padding: 10px;
            text-align: center;
            width: 200px;
            font-size: 30px;
        }
        
        .form-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        label {
            display: block;
            margin: 10px 0;
        }
         .styled-button {
    background-color: #5cb85c;
    color: #ffffff;
    border: none; 
    padding: 10px 20px; 
    border-radius: 5px;
    cursor: pointer; 
    width: 75px;
   
  }

  .styled-button:hover {
    background-color: #f0ad4e; /* Change the background color on hover */
  }
    </style>
</head>
<body>
<h1 align="center">Cart Page</h1>

<%HttpSession hs=request.getSession(false); %>
<% String username=(String)hs.getAttribute("username"); %>

<%!ArrayList<Integer> booklist=new ArrayList<>(); %>

<% 
    // Add prices to the 'booklist' for each product, replace with the actual attribute names
    String[] productIds = {"M1", "M2", "M3", "M4", "M5", "M6", "H1", "H2", "H3", "H4", "H5", "H6", "E1", "E2", "E3", "E4", "E5", "E6"};
    for (String productId : productIds) {
        Integer price = (Integer)hs.getAttribute(productId);
        if (price != null) {
            booklist.add(price);
        }
    }
%>   
<% 
    int sum = 0;
    for (Integer price : booklist) {
        sum =sum+ price;
    }
%>
<div class=outerdiv>
<form  method="post" action="LogoutServlet">
<div class="div1">Welcome&nbsp;&nbsp;&nbsp;<u><%=username %></u></div>
<br>
 <span style="position: relative; left: 40px;"><big> Total Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</big>  

<button type="submit" class="styled-button" ><%= sum %></button> </span>
</form>

</div>
 

</body>
</html>