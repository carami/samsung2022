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
<p>
<c:if test="${todo.done}"> 완료^^</c:if>
<c:if test="${!todo.done}"> 진행중.....</c:if>

<a href="update?id=${todo.id }">${todo.todo}</a>
<a href="delete?id=${todo.id }">삭제</a>
</p>
</c:forEach>



<br><br>
<hr>


<form method="post" action="add">
	할일 : <input type="text" name="todo" placeholder="할일을 입력하세요!!" />
	<input type="submit" value="할일 추가" />
</form>
</body>
</html>