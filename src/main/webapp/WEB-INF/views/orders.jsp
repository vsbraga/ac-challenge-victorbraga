<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AC E-commerce</title>>
</head>
<body>
	<div align="center">
		<h1>Place order</h1>
		<table>
			<form:form action="save" method="post" modelAttribute="order">
			<form:hidden path="id"/>
			<tr>
				<td>Insert product name</td>
				<td><form:input path="product"/></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description"/></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:password path="price"/></td>
			</tr>
			<tr>
				<td>user name</td>
				<td><form:password path="userName"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
	
</body>
</html>