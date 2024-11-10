<%@page import="com.jspiders.servelets.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<style type="text/css">
/* Resetting default margins, paddings, and box-sizing */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body, html {
	height: 100%;
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	display: flex;
	justify-content: center;
	align-items: center;
}

/* Styling the form container */
.form-container {
	background-color: #fff;
	padding: 30px;
	border-radius: 15px;
	box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.1);
	width: 350px;
	animation: fadeIn 1s ease-out;
}

/* Styling the table */
table {
	width: 100%;
	border-collapse: separate;
	border-spacing: 0 15px;
}

/* Styling the table cells */
td {
	padding: 10px 0;
	font-size: 16px;
	color: #333;
}

/* Styling the input fields */
input[type="text"], input[type="password"] {
	width: 100%;
	padding: 12px;
	border: 1px solid #ddd;
	border-radius: 5px;
	font-size: 16px;
	transition: all 0.3s ease;
}

input[type="text"]:focus, input[type="password"]:focus {
	border-color: #4CAF50;
	box-shadow: 0 0 10px rgba(76, 175, 80, 0.1);
}

/* Styling the Signup button */
button {
	width: 100%;
	padding: 12px;
	margin-top: 20px;
	border: none;
	background-color: #4CAF50;
	color: white;
	font-size: 18px;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.3s ease;
}

/* Button hover effect */
button:hover {
	background-color: #45a049;
	transform: translateY(-2px);
}
</style>
</head>
<body>
	<div class="form-wrapper">
		<div class="form-container">
			<%
				User user = (User) request.getAttribute("user");
			%>
			<form action="./update-user" method="post">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" placeholder="Enter your username" name="username" value="<%= user.getUsername() %>" readonly="readonly"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" placeholder="Enter your email" name="email" value="<%= user.getEmail() %>" readonly="readonly"></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><input type="text" placeholder="Enter your mobile number" name="mobile" value="<%= user.getMobile() %>"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" placeholder="Enter your password" name="password" value="<%= user.getPassword() %>"></td>
					</tr>
				</table>
				<button type="submit">Update</button>
			</form>
		</div>
	</div>
</body>
</html>
