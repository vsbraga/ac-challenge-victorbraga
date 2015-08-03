<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AC E-commerce</title>
    </head>
    <body>
        <div align="center">
            <h1>Contact List</h1>
            <table border="1">
                <th>id</th>
                <th>Product</th>
                <th>Description</th>
                <th>Price</th>
                <th>User Name</th>
                <th>Order Date</th>
                 
                <c:forEach var="order" items="${orderList}" varStatus="o">
                <tr>
                    <td>${o.id}</td>
                    <td>${o.product}</td>  
                    <td>${o.description}</td> 
                    <td>${o.price}</td> 
                    <td>${o.userName}</td> 
                   <td>${o.orderDate}</td> 
                   <td>
						<a href="edit?id=${o.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?id=${o.id}">Delete</a>
					</td>                            
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>