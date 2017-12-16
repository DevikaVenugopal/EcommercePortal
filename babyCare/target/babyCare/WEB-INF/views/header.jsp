<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Header</title>
</head>
<style>
.navbar-custom {
border-color: #EC87C0;
    background-color:   #E35760;
}
</style>
<body>
<nav class="navbar navbar-inverse navbar-custom">
<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="./"><font color="white">babyCare</font></a>
    </div>
    <ul class="nav navbar-nav">
 
      <c:if test="${pageContext.request.userPrincipal.name  != 'devikavenugopal95@gmail.com'}">
      <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#"><font color="white">Category List</font>
      <span class="caret"></span></a>
      <ul class="dropdown-menu">
      <c:forEach items="${categoryList}" var="category">
      <li><font color="black"><a href="productList?catId=${category.catId}">${category.catName}</font></a></li>
      </c:forEach>
      </ul>
      </li></c:if>
       <c:if test="${pageContext.request.userPrincipal.name  == 'devikavenugopal95@gmail.com'}">
              <li><a href="adding"><font color="white">Admin</font></a>              
              </li>  
       </c:if>
       
       </ul>
      
     
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${pageContext.request.userPrincipal.name == null }">
      <li><a href="Login"><font color="white"><span class="glyphicon glyphicon-log-in"></span>Login</font></a></li>
      <li><a href="Register"><font color="white">Register</font></a></li>
       </c:if>
       <c:if test="${pageContext.request.userPrincipal.name != null && pageContext.request.userPrincipal.name  != 'devikavenugopal95@gmail.com'}">
            <li>       
            <a href="Cart?status="><font color="white">Cart</font><i class="fa fa-shopping-cart" ></i></a> 
            </li> 
            </c:if>
       <c:if test="${pageContext.request.userPrincipal.name  != null}">
					<li><a><font color="white">Welcome: ${pageContext.request.userPrincipal.name}</font></a></li>
					<li><a href='<c:url value="/j_spring_security_logout" />'><font color="white">Logout</font></a></li>
				</c:if>
		  		
    </ul>
  </div>
  </nav>
</body>
</html>