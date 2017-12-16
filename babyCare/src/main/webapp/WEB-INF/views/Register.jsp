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
<input path="name" placeholder="Enter Name"  pattern="[a-zA-Z]{1,15}" title="Special Characters not allowed"  class="form-control" name="name" required />
</div>
<div class="form-group">
<label>Email</label>
<input path="email" placeholder="Enter email id" class="form-control" name="mail" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="eg:syama@gmail.com"  required/>
</div>
<div class="form-group">
<label>Password</label>
<input path="password" type="password" placeholder="Enter password" class="form-control" name="pwd" pattern=".{6,}" required/>
</div>
<div class="form-group">
<label>Phone Number</label>
<input path="phone" placeholder="Enter Phone number" class="form-control" name="phone" pattern="[789][0-9]{9}" required/>
</div>
<div class="form-group">
<label>Country</label>
<input path="country" placeholder="Enter country" class="form-control" name="con" required/>
</div>
<div class="form-group">
<label>Address</label>
<input path="address" placeholder="Enter address" class="form-control" name="add" required/>
</div>
<button tupe="Submit" class="btn btn-lg btn-info">Submit</button>
<button type="Reset" class="btn btn-lg btn-info">Reset</button>
</form>
</div>
</div>
  <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>