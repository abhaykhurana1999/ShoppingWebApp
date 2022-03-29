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
		<b><h2>Shopping Cart</h2></b>
	</center>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">NAME</th>
				<th scope="col">Price</th>
				<th scope="col">Units</th>
				<th scope="col">Category</th>
			</tr>
		</thead>

	</table>
	<%
	ArrayList cartdata = (ArrayList) session.getAttribute("cartProducts");
	if (cartdata == null || cartdata.isEmpty()) {
		%>



		<h2>YOUR SHOPPING CART IS EMPTY</h2>
		<%
	}
	Iterator<Product> it = cartdata.iterator();
	while (it.hasNext()) {
		Product product = it.next();
	%>
	<table class="table table-bordered">

		<tbody>
			<tr>
				<td><%=product.getId()%></td>
				<td><%=product.getName()%></td>
				<td><%=product.getPrice()%></td>
				<td><%=product.getUnits()%></td>
				<td><%=product.getCategory()%></td>
				<td><a href="deleteitem.do?id=<%=product.getId()%>">Remove</a></td>
				
			</tr>

		</tbody>
	</table>

	<%
	}
	%>
	<a href="Logout.do">Logout</a>
	</table>

</body>
</html>