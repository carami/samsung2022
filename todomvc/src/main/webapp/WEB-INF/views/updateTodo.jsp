<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Todo update</h1>

<form method="post" action="updateTodo">
<input type="hidden" name="id" value="${todo.id} }">
	할일 : <input type="text" name="todo" value="${todo.todo} }">
	<input type="submit" value="추가">
</form>
</body>
</html>