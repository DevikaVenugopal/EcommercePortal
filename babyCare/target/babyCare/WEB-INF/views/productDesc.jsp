<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Description</title>
</head>
<body>
<table>

<tr>
    <td rowspan="5">
      <img alt="" src="<c:url value="/resources/images/${Product.productId}.jpg"/>">
    </td>
    <td>&nbns;</td>  
</tr>
<tr>
    <td>Product ID :${product.productId}</td>
</tr>   
<tr>
    <td>Product Name :${product.productName}</td>
</tr>   
<tr>
    <td>Product Description :${product.productDesc}</td>
</tr>  
<tr>
   <td>&nbns;</td>
</tr>     
</table>
</body>
</html>