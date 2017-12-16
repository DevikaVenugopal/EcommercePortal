<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier-babyCareFrontEnd</title>
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
<h2>Supplier List</h2>
<h2 style="color: red;">${status}</h2>

<div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Supplier Id</th>
        <th>Supplier Name</th>
        <th>Supplier Address</th>
        <th>Supplier Operation</th>
      </tr>
    </thead>
<c:forEach items="${supplierList}" var="Supplier">
<tr bgcolor="pink">
<td>${Supplier.supplierId}</td>
<td>${Supplier.supplierName}</td>
<td>${Supplier.supplierAddress}</td>
<td>
    <a href="<c:url value="deleteSupplier/${Supplier.supplierId}"/>">DELETE</a>/
    <a href="<c:url value="updateS?supplierId=${Supplier.supplierId}"/>">UPDATE</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>