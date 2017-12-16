<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<style type="text/css">
body
{
    background: url('./resources/images/Background-Vector.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
    
}

</style>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container">
<h1>REGISTER</h1>
<div class="Col-lg-12">
<div class="row">
<form action="user" method="post">
<div class="col-lg-10">
<div class="form-group">
<label>Name</label>
<input path="name" placeholder="Enter Name" class="form-control" name="name"/>
</div>
<div class="form-group">
<label>Email</label>
<input path="email" placeholder="Enter email id" class="form-control" name="mail"/>
</div>
<div class="form-group">
<label>Password</label>
<input path="password" type="password" placeholder="Enter password" class="form-control" name="pwd"/>
</div>
<div class="form-group">
<label>Phone Number</label>
<input path="phone" placeholder="Enter Phone number" class="form-control" name="phone" pattern="[789][0-9]{9}"/>
</div>
<div class="form-group">
<label>Country</label>
<input path="country" placeholder="Enter country" class="form-control" name="con"/>
</div>
<div class="form-group">
<label>Address</label>
<input path="address" placeholder="Enter address" class="form-control" name="add"/>
</div>
<button tupe="Submit" class="btn btn-lg btn-info">Submit</button>
<button type="Reset" class="btn btn-lg btn-info">Reset</button>
</form>
</div>
</div>
</body>
</html>