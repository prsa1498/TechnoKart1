<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
import="java.util.*,com.lti.entity.*"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"/>     --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="view" class="com.lti.controller.MainController" scope="page"/>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<jsp:include page="menu2.jsp" />
<%
String contextPath = "./resources/images/";
String link="";
%>
<%List<ProductEntity> productList = (List<ProductEntity>)session.getAttribute("product"); %> 
<div class="w3-content w3-section" style="max-width:500px">
<div class="page-title"> 
   <div class="row">
		<%for(int i=0;i<(productList.size());i++) { %>
		<% link = contextPath + productList.get(i).getImagetolink();%>
			<img src="<%=link %>" alt="<%out.print(link); %>" class="image"/> 
			</div>
				<p>
					<b><u><%=productList.get(i).getP_name() %></u></b>
				</p>
				<p>
				Price - <%= productList.get(i).getP_price()%>
			</p>
			<p>
			Details - <%=productList.get(i).getP_details() %>
			</p>
			<p>
			<a href="prodToCart.lti?id=<%=productList.get(i).getP_id() %>">
			<button class="button">Add to Cart</button></a>
			<a href="prodToWish.lti?id=<%=productList.get(i).getP_id() %>">
			<button class="button">Add to Wishlist</button></a>
			</p>
		</div>
		<%} %>
  <jsp:include page="footer.jsp" />
</body>
</html>