<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">

div{
margin-top: 100px;
}
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-image:url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
h1{
color:red;
}
h2{
color:orange;
}
#sub{
background-color: green;
}
</style>
</head>
<body>
	<div align="center" >
		<h1>🖥️ ADMIN LOGIN 🖥️</h1>
		<form action="./login" method="post">
			<fieldset>
				<legend>LOGIN TO PROCEED</legend>
				<table>
					<tr>
						<td>Username:</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
			</fieldset>
			<input id="sub" type="submit" value="LOGIN">
		</form>
		<br>
		<a href="./createAdmin">Create new account</a>
		
		<%
		if (msg != null) {
		%>
		<h2><%=msg%></h2>
		<%
		}
		%>
	</div>
</body>
</html>