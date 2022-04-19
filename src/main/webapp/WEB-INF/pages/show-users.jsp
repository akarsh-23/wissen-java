<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Users List</h1>
<table>
	<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.getId()}</td>
			<td>${user.getName()}</td>
			<td>${user.getAge()}</td>
		</tr>
	</c:forEach>
</table>