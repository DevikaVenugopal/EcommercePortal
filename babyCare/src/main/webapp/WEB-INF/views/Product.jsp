<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product-babyCareFrontEnd</title>
<style type="text/css">
body
{
    background: url('${pageContext.request.contextPath}/resources/images/b7.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container">
<h2>Product List</h2>
<h2 style="color: red;">${status}</h2>

<div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Product Stock</th>
        <th>Product Price</th>
        <th>Product Image</th>
        <th>Category Name</th>
        <th>Supplier name</th>
        <th>Product Operation</th>
      </tr> 
      </thead>
      <tbody>
      <c:forEach items="${productList}" var="product">
	<tr bgcolor="pink">
		<td>${product.productId}</td>
		<td>${product.productName}</td>
		<td>${product.productDesc}</td>
		<td>${product.stock}</td>
		<td>${product.price}</td> 
        <td>
		<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="50px" height="50px"/>
		</td>
        <td>${product.supplier.supplierName}</td>
		<td>${product.category.catName}</td>
		<td>
			<a href="<c:url value="deleteProduct/${product.productId}"/>">DELETE</a>/
			<a href="<c:url value="updateP?productId=${product.productId}"/>">UPDATE</a>
		</td>
	</tr>
	
	</c:forEach>
    </tbody>
   </table>
   </div>
   </div>
   <br/>
   <br/>
   <br/>
   <br/>
     <jsp:include page="Footer.jsp"></jsp:include>
   
</body>
</html>