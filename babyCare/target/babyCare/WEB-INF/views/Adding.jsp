<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix = "c"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
<title>Adding</title>
<style type="text/css">
body
{
    background: url('${pageContext.request.contextPath}/resources/images/b2.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<div class="container">
<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#category">Category</a></li>
  <li><a data-toggle="tab" href="#supplier">Supplier</a></li>
  <li><a data-toggle="tab" href="#product">Product</a></li>
  <li><a data-toggle="tab" href="#update">Update</a></li>
</ul>

<div class="tab-content">
<div id="category" class="tab-pane fade in active">
<h2>Category Module</h2>
<form action="AddCategory" method="post" class="form-horizontal">
 <div class="form-group">
      <label class="control-label col-sm-2" for="catName">Category Name</label>
      <div class="col-sm-10">
        <input class="form-control" id="catName"  name="catName">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="catDesc">Category Description</label>
      <div class="col-sm-10">
        <input class="form-control" id="catDesc"  name="catDesc">
      </div>
</div>
<div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Insert</button>
      </div>
</div>
</form>
</div>
<div id="supplier" class="tab-pane fade">
<h2>Supplier Module</h2>
<form action="AddSupplier" method="post" class="form-horizontal">
 <div class="form-group">
      <label class="control-label col-sm-2" for="supplierName">Supplier Name</label>
      <div class="col-sm-10">
        <input class="form-control" id="supplierName" name="supplierName">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="supplierAddress">Supplier Address</label>
      <div class="col-sm-10">
        <input class="form-control" id="supplierAddress"  name="supplierAddress">
      </div>
</div>
<div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Insert</button>
      </div>
</div>
</form>
</div>
  <div id="product" class="tab-pane fade">
   <form action="InsertProduct" enctype="multipart/form-data"  method="post" class="form-horizontal">
 <div class="form-group">
      <label class="control-label col-sm-2" for="productName">Product Name</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" id="productName"  name="productName">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="productDesc">Product Description</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" id="productDesc"  name="productDesc">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="stock">Stock</label>
      <div class="col-sm-10">
        <input class="form-control" type="number" id="stock"  name="productStock">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="price">Price</label>
      <div class="col-sm-10">
        <input class="form-control" id="price" type="number" name="productPrice">
      </div>
</div>
    
<div class="form-group">
    <h4>Select Category</h4><br>
    <select class="form-control" name="pCat" required>
    <option value="">------Category Choices----------</option>
    <c:forEach items="${categoryList}" var="category">
    <option value="${category.catId}">${category.catName}</option>
    </c:forEach>
    </select>
</div>

<div class="form-group">
    <h4>Select Supplier</h4><br>
    <select class="form-control" name="pSupplier" required>
    <option value="">------Supplier Choices----------</option>
    <c:forEach items="${supplierList}" var="supplier">
    <option value="${supplier.supplierId}">${supplier.supplierName}</option></c:forEach>
    </select>
</div>
<br><br>

<div class="fileinput fileinput-new" data provides="fileinput">
    <tr>
    <td>Image</td>
    <td><input class="form-control" type="file" name="file" accept="image/*"></td>
    </tr>
</div>
    <button class="btn btn-lg btn-primary" type="submit">Save</button>
    <button class="btn btn-lg btn-primary" type="reset">Cancel</button>
</form>
</div>
   <div id="update" class="tab-pane fade"><br><br>
     <a href="category" class="btn btn-primary btn-block">Category List</a><br/>
     <a href="supplier" class="btn btn-primary btn-block">Supplier List</a><br/>
     <a href="product" class="btn btn-primary btn-block">Product List</a><br/>
  </div>
  
</div>

</div>

</body>
</html>