<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>Add User</h1>
<form:form action="addUser" method="POST" modelAttribute="user">
	<form:input path="name"/>
	<form:input path="age"/>
	<input type=submit value="Add"/>
</form:form>