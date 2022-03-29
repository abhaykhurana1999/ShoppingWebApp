<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

	<center>
		<b><h2>Register Customer</h2></b>
	</center>


	<form method="get" action="Register.do">

		<h3>Enter Username of The Customer</h3>
		<input type="text" name=username>
		<h3>Enter Password!!</h3>
		<input type="text" name=password>
		<h3>Enter Firstname:</h3>
		<input type="text" name=firstname>
		<h3>Enter Lastname</h3>
		<input type="text" name=lastname>
		<h3>Enter Phone No of The Customer</h3>
		<input type="text" name=phone>
		<h3>Enter Email</h3>
		<input type="text" name=email>
		<h3>Enter billingaddress of The Customer</h3>
		<input type="text" name=billingaddress>
		<h3>Enter shippingaddress of The Customer</h3>
		<input type="text" name=shippingaddress> <input type="submit"
			value="Submit">
	</form>
</body>
</html>