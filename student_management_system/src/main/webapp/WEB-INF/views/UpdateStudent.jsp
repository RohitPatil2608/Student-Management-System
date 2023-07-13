<%@page import="com.jspiders.student_management_system.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />

<%
String msg = (String) request.getAttribute("msg");
StudentPOJO student = (StudentPOJO) request.getAttribute("student");
List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("students");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
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
		<%
		if (student == null) {
		%>
		<form action="./update" method="post">
			<fieldset>
				<legend>SELECT STUDENT:</legend>
				<table>
					<tr>
						<td>Enter ID:</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</fieldset>
			<input id="sub" type="submit" value="SELECT">
		</form>
		<%
		if (msg != null) {
		%>
		<h4><%=msg%></h4>
		<%
		}
		%>
		
		<%
		if (students != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Address</th>
			</tr>
			<%
			for (StudentPOJO pojo : students) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getMobile()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
			<%
			}
			}
			%>
		</table>
		<%
		} else if (student != null) {
		%>
		<form action="./updateData" method="post">
			<fieldset>
				<legend>UPDATE STUDENT DETAILS:</legend>
				<table>
					<tr hidden="true">
						<td>ID</td>
						<td><input type="text" name="id" 
							value="<%=student.getId()%>"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"
							value="<%=student.getName()%>"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"
							value="<%=student.getEmail()%>"></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><input type="text" name="mobile"
							value="<%=student.getMobile()%>"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"
							value="<%=student.getAddress()%>"></td>
					</tr>
				</table>
			</fieldset>
			<input id="sub" type="submit" value="UPDATE">
		</form>
		<%
		}
		%>

	</div>
</body>
</html>