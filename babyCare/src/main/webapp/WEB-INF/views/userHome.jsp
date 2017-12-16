<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table cellspacing="2" align="center">
<tr bgcolor="gray">
   <td>Product Name</td>
   <td>Price</td>
   <td>Category</td>
   <td>Stock</td>
   <td>Photo</td>
 </tr>
 <c:forEach items="${productList }" var="Product">
   <tr>
       <td>${Product.productName}</td>
       <td>${Product.price}</td>
       <td>${Product.catId}</td>
       <td>${Product.stock}</td>
       <td>
       <a href="productDesc/${Product.productId }">
       <img src="<c:url value="/resources/images/${Product.productId}.jpg"/>" width="100px" height="100px"/>   
       </td> 
       </a>
   </tr>
 </c:forEach>
</table>

</body>
</html>