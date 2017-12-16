<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateSupplier-babyCareFrontEnd</title>
<style type="text/css">
body
{
    background: url('${pageContext.request.contextPath}/resources/images/b6.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container">
<h2>Supplier Module</h2>
<form action="AddSupplier" method="post" class="form-horizontal">
 <div class="form-group">
      <label class="control-label col-sm-2" for="supplierName">Supplier Name</label>
      <div class="col-sm-10">
        <input class="form-control" id="supplierName" placeholder="Enter Supplier Name" name="supplierName" value="${sup.supplierName }">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="supplierDesc">Supplier Description</label>
      <div class="col-sm-10">
        <input class="form-control" id="supplierDesc" placeholder="Enter Supplier Description" name="supplierDesc" value="${sup.supplierAddress}">
      </div>
</div>
<div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Update Supplier</button>
      </div>
</div>
</form>
</div>
</body>
</html>