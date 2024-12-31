<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Page</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        form {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        h2 {
            margin: 0;
            padding: 10px 0;
            border-bottom: 1px solid #ccc;
        }
        label {
            display: block;
            margin: 10px 0;
        }
        input[type="text"] {
            width: 90%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin-left:200px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%HttpSession hs=request.getSession(false); %>
<% String user=(String)hs.getAttribute("username"); %>

<h1 align="center">Payment Page</h1>
    <form action="PaymentServlet" method="post">
        <h2>Payment Information - </h2>
        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" required>
        <br><br>

        <label for="expiryDate">Expiry Date (MM/YY):</label>
        <input type="text" id="expiryDate" name="expiryDate" required>
        <br><br>

        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" required>
        <br><br>

        <h2>Billing Address - </h2>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>
        <br><br>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" required>
        <br><br>

        <label for="pinCode">Pin Code:</label>
        <input type="text" id="pinCode" name="pinCode" required>
        <br><br>

        <input type="submit" value="Make Payment">
    </form>

</body>
</html>