<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Category-babyCareFrontEnd</title>
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
<h2>Category List</h2>
<h2 style="color: red;">${status}</h2>

<div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Category Id</th>
        <th>Category Name</th>
        <th>Category Description</th>
        <th>Category Operation</th>
      </tr>
    </thead>
<c:forEach items="${categoryList }" var="category">
<tr bgcolor="pink">
        <td>${category.catId}</td>
        <td>${category.catName}</td>
        <td>${category.catDesc}</td>
    <td>
    <a href="<c:url value="deleteCategory/${category.catId}"/>">DELETE</a>/
    <a href="<c:url value="updateC?catId=${category.catId}"/>">UPDATE</a>
    </td>
</tr>

</c:forEach>
</table>
</div>
</div>
  <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>