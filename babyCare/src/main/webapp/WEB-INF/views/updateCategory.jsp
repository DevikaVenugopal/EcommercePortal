<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateCategory-babyCareFrontEnd</title>
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
<h2>Category Module</h2>
<form action="UpdateCategory" method="post" class="form-horizontal">
 <div class="form-group">
      <label class="control-label col-sm-2" for="catName">Category Name</label>
      <div class="col-sm-10">
         <input  type="hidden" name="catId" value="${cat.catId}">
        <input class="form-control" id="catName" placeholder="Enter Category Name" name="catName" value="${cat.catName }">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="catDesc">Category Description</label>
      <div class="col-sm-10">
        <input class="form-control" id="catDesc" placeholder="Enter Category Description" name="catDesc" value="${cat.catDesc }">
      </div>
</div>
<div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Update Category</button>
      </div>
</div>
</form>
</div>
  <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>