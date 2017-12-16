<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<style type="text/css">
body
{
    background: url('${pageContext.request.contextPath}/resources/images/b12.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>





<div class="container">
<h1>Cart</h1>
    <div class="row">
    <h3 style="color: red;">${status}</h3>
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                <c:if test="${empty cartInfo }">
                <tr><td colspan="7" align"center">No Cart Items</td></tr>
                </c:if>
                
                <c:forEach var="c" items="${cartInfo}">
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"><img class="media-object" src="${pageContext.request.contextPath}/resources/images/${c.product.productId}.jpg" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${c.product.productName}</a></h4>
                                <h5 class="media-heading"> by <a href="#">${c.product.supplier.supplierName}</a></h5>
                               
                            </div>
                        </div></td>
                     
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                           <form action="updateCart" method="post">
                           <input type="hidden" name="cid" value="${c.cartId}"/>
                           <input type="number" class="form-control" id="exampleInputEmail1" name= "qty" value="${c.cartQnty}"><br/>
                           <button type="submit" class="btn btn-default btn-sm">
         					 <span class="glyphicon glyphicon-refresh"></span> Refresh
       				       </button>
       				    	</form>
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${c.product.price}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${c.cartQnty*c.product.price}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        <td><a href="deleteCart/${c.cartId}" class="btn btn-lg btn-danger"><span class="glyphicon glyphicon-remove"></span></a>
                        <td>
                        
       				    </td>
					
                        </tr>
                    <tr>
                        
                        <c:set var="gtot" value="${gtot+c.product.price*c.cartQnty}">
                        </c:set>
                       
                    </tr>
                    
                   
                    </c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td><span class="col-lg-7" align="right"><label>Grand Total</label>
                        <c:out value="${gtot}"></c:out></span></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <tr>
                        <td><a href="./" class="btn btn-warning">Continue Shopping</a></td>
                        <c:if test="${not empty cartInfo}">
                        <td><a href="Checkout" class="btn btn-success">Checkout</a></td>
                        </c:if>
                    </tr>
                    
                </tbody>
            </table>
        </div>
    </div>
  </div>
</body>
</html>