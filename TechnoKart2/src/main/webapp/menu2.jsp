<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<jsp:include page="header.jsp" />
   <div class="menu-container">
 <p align="right" style="  color: #004d99;
    font-weight: bold;"> Hello <% 
String name=(String)session.getAttribute("u_name"); 
out.print(name); 
%>
|
<a href="${contextPath}/showCart.lti">MyCart</a>
|
<a href="${contextPath}/showWish.lti">WishList</a>
|
<a href="${contextPath}/showProd.lti">Product List</a>
|
<a href="uPassReset.jsp">Reset Password</a>
|
<a href="${contextPath}/logout.lti">Logout</a>
 </p>
</body>
</html>