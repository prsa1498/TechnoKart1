<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Retailer's First Page</title>
</head>
<body>
 <jsp:include page="header.jsp" />
<jsp:include page="adminmenu.jsp" /> 
<marquee>Welcome !</marquee></h2>
 <img class="logo" alt="logo" src="./resources/images/admin.png" height="300" width="300" align ="middle"><br>
<a href="addProduct.jsp"><button type="submit" class="button" align="middle">Add Product</button></a>
</body>
</html>