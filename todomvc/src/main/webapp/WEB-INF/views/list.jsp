<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo List</title>
</head>
<body>
<h1>ToDo List</h1>

<form method="post" action="addToDo">
	할일 : <input type="text" name="todo">
	<input type="submit" value="추가">
</form>

<c:forEach var="todo" items="${todos }" varStatus="status">
${todo.todo } <br>

</c:forEach>

</body>
</html>