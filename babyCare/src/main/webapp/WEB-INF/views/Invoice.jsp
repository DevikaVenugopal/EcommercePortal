<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Date" %>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form action="/Invoice" class="form-horizontal">
<div class="container">
	    <div class="row color-invoice">
      <div class="col-md-12">
        <h4>#Order Date: <%=new Date()%></h4><h4 class="pull-right"><br>Order # ${Order.orderId }</h4>
        <div class="row">
          <div class="col-lg-7 col-md-7 col-sm-7">
            <h1>INVOICE</h1>
          </div>
          <c:set var="gtot" value="0"></c:set>
<c:forEach var="c" items="${Cart}">
<c:set var="gtot" value="${gtot+c.product.price*c.cartQnty}"></c:set>
</c:forEach>
        </div>
        <hr />
        <div class="row">
          <div class="col-lg-7 col-md-7 col-sm-7">
             <hr>
            <div class="row">
                <div class="col-xs-6">
                    <address>
                    <h3><strong>Customer Details:</strong></h3><br>
                        ${User.name }<br>
                        ${User.address }<br>
                        ${User.phone }<br>
                        ${User.country }<br>
                        ${user.phone}<br>
                        ${user.email}<br>
                    </address>
                </div>
          </div>
        </div>
        <hr />
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <strong>ITEM DESCRIPTION & DETAILS :</strong>
          </div>
        </div>
        <hr />
          <div class="row">

        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
             
                
                <c:forEach var="c" items="${Cart}">
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
                          ${c.cartQnty}
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${c.product.price}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${c.cartQnty*c.product.price}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        
                        
                           </td>
                    
                        </tr>
                    <tr>
                       
                       
                    </tr>
                    
                   
                    </c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td><span class="col-lg-7" align="right"><label>Grand Total</label>
                        <c:out value="${gtot}"></c:out></span></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <tr>
                      
                    </tr>
                   
        
                </tbody>
            </table>
</div>
</div>
</div>
</div>
</div>
 <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
            <a href="#" class="btn btn-success btn-sm" onclick="printfun()">Print Invoice</a>    
            <a href="ackOrder"  class="btn btn-info btn-sm">Place Oder</a>
          </div>
</div>
</form>
<script type="text/javascript">
function printfun() 
{
	window.print();
	
}
</script>
<br/> <br/> <br/> <br/>
  <br/> <br/> <br/> <br/>
   <br/> <br/> <br/> <br/>
    <br/> <br/> <br/> <br/>
  <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>