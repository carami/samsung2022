<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ToDo List!!</h1>

<c:forEach     var="todo" items="${todoList}">
<p>${todo.todo}  </p>


</c:forEach>



</body>
</html>