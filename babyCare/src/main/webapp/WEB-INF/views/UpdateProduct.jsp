<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateProduct-babyCareFrontEnd</title>
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
<h2>Product Module</h2>
<form action="updateProduct" enctype="multipart/form-data"  method="post" class="form-horizontal">
 <div class="form-group">
      <label class="control-label col-sm-2" for="productName">Product Name</label>
      <div class="col-sm-10">
      <input type="hidden" name="productId" value="${prod.productId}">
        <input class="form-control" type="text" id="productName"  name="productName" value="${prod.productName}">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="productDesc">Product Description</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" id="productDesc"  name="productDesc" value="${prod.productDesc}">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="stock">Stock</label>
      <div class="col-sm-10">
        <input class="form-control" type="number" id="stock"  name="productStock" value="${prod.stock}">
      </div>
</div>
<div class="form-group">
      <label class="control-label col-sm-2" for="price">Price</label>
      <div class="col-sm-10">
        <input class="form-control" id="price" type="number" name="productPrice" value="${prod.price}">
      </div>
</div>
    
<div class="form-group">
    <h4>Select Category</h4><br>
    <select class="form-control" name="pCat"  value="${prod.category}" required>
    <option value="">------Category Choices----------</option>
    <c:forEach items="${categoryList}" var="category">
    <option value="${category.catId}">${category.catName}</option>
    </c:forEach>
    </select>
</div>

<div class="form-group">
    <h4>Select Supplier</h4><br>
    <select class="form-control" name="pSupplier" value="${prod.supplier}" required>
    <option value="">------Supplier Choices----------</option>
    <c:forEach items="${supplierList}" var="supplier">
    <option value="${supplier.supplierId}">${supplier.supplierName}</option></c:forEach>
    </select>
</div>
<br><br>

<div class="fileinput fileinput-new" data provides="fileinput">
    <tr>
    <td>Image</td>
    <td><input class="form-control" type="file" name="pimage" value="${prod.pimage}" accept="image/*"></td>
    </tr>
</div>
    <button class="btn btn-lg btn-primary" type="submit">Save</button>
    <button class="btn btn-lg btn-primary" type="reset">Cancel</button>
</form>
</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
  <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>