<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edited from the other Workspace</h1>
	<form action="EmployeeManagerServlet" method="post">
		Id: <input type="text" name="id" size="20"><br><br>
		Age: <input type="text" name="age" size="20"><br><br>
		Name: <input type="text" name="name" size="20"><br><br>
		Access Level: <input type="text" name="access" size="20"><br><br>
		<input type="submit" value="add Employee" />
	</form>
</body>
</html>