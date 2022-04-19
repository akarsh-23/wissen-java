<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>Delete User</h1>
<form:form action="deleteUser" method="POST" modelAttribute="user">
	<form:input path="id"/>
	<input type=submit value="delete"/>
</form:form>