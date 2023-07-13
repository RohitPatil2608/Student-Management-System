
<%@page import="com.jspiders.student_management_system.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />

<%
StudentPOJO pojo = (StudentPOJO) request.getAttribute("student");
String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Student</title>
<style type="text/css">
body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
	margin-top: 20px;
}
#data td {
	border: 1px solid black;
	text-align: center;
}

#sub {
	color: white;
	background-color: green;
}
#data tr th{
background-color: yellow;
border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>

	<div align="center">
		<form action="./search" method="post">
			<fieldset>
				<legend>SEARCH STUDENT DETAILS</legend>
				<table>
					<tr>
						<td>Enter ID:</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</fieldset>
			<input id="sub" type="submit" value="SEARCH">
		</form>

		<%
		if (msg != null) {
		%>
		<h4><%=msg%>
		</h4>
		<%
		}
		%>



		<%
		if (pojo != null) {
		%>
		<table id="data" border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Address</th>
			</tr>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getMobile()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>