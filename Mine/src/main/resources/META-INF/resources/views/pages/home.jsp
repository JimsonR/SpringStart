 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "/api/addStudent">
<input type = "text" name = "name"><br>
<input type = "text" name = "id"><br>

<input type = "submit"><br>
</form>
<form action = "/api/getStudent">
<input type = "text" name = "id"><br>
<input type = "submit"><br>
</form>

<form action = "delAlien">
<input type = "text" name = "aid"><br>
<input type = "submit"><br>
</form>

<form action="/api/allStudents">
    <input type="submit" value="all students">
</form>
</body>

</html>